package com.sukyky.setup;

import com.sukyky.model.Stock;
import com.sukyky.model.TradeOrder;
import com.sukyky.model.Trader;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * @author huljas
 */
public class DataInitializer {

    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);


    private Resource tradeOrderData;

    public void setTradeOrderData(Resource tradeOrderData) {
        this.tradeOrderData = tradeOrderData;
    }

    @Autowired
    private DataInitializerRepository dataInitializerRepository;

    public void init() throws Exception {
        if (dataInitializerRepository.hasTradeOrders()) {
            logger.info("Data is already loaded, skipping");
            return;
        }

        if (tradeOrderData != null) {
            loadDataFile();
        } else {
            populateData();
        }
    }

    public void loadDataFile() throws IOException {
        logger.info("Loading data from file");
        File file = tradeOrderData.getFile();
        ZipFile zipFile = new ZipFile(file);
        ZipEntry entry = zipFile.entries().nextElement();
        InputStream input = zipFile.getInputStream(entry);
        File result = new File(file.getParentFile(), entry.getName().replace(".zip", ".dump"));
        if (!result.exists()) {
            logger.info("Extracting " + file.getAbsolutePath() + " to " + result.getAbsolutePath());
            OutputStream output = new FileOutputStream(result);
            IOUtils.copy(input, output);
            IOUtils.closeQuietly(output);
        }
        IOUtils.closeQuietly(input);
        zipFile.close();

        logger.info("Loading data from " + result.getAbsolutePath());

        dataInitializerRepository.loadDataFile(result);
        
        logger.info("Deleting " + result.getAbsolutePath());
        result.delete();

        logger.info("Data loaded OK!");
    }


    public void populateData() throws InterruptedException {
        LocalDate now = new LocalDate();
        LocalDate start = new LocalDate(now.getYear() - 1, 1, 1);
        final long startL = start.toDateTimeAtStartOfDay().getMillis();
        final long endL = now.toDateTimeAtCurrentTime().getMillis();
        final long diff = endL - startL;

        logger.info("Populating trade data!");
        if (!dataInitializerRepository.hasTradeOrders()) {
            final List<Stock> stocks = dataInitializerRepository.getStocks();
            final List<Trader> traders = dataInitializerRepository.getTraders();
            final int n = 100000;
            long time = System.currentTimeMillis();
            ExecutorService executor = Executors.newFixedThreadPool(8);
            for (final Stock stock : stocks) {
                executor.submit(new Runnable() {
                    public void run() {
                        Random random = new Random();
                        int price = random.nextInt(500 + 60000);
                        List<TradeOrder> batch = new ArrayList<TradeOrder>();
                        for (int i = 0; i < n; i++) {
                            Trader seller = traders.get(random.nextInt(traders.size()));
                            Trader buyer = traders.get(random.nextInt(traders.size()));
                            TradeOrder order = new TradeOrder();
                            order.buyer = buyer;
                            order.seller = seller;
                            order.stock = stock;
                            order.priceA = price + random.nextInt(200) - 100;
                            price = order.priceA;
                            long time = startL + i * diff / n;
                            LocalDateTime dateTime = new LocalDateTime(time);

                            // 0.00-23.59
                            int millisOfDay = dateTime.getMillisOfDay();

                            // 0.00-8.00
                            int workMillisOfDay = millisOfDay / 3;

                            
                            LocalDateTime workTime = dateTime.millisOfDay().setCopy(workMillisOfDay).plusHours(10);
                            
                            if (workTime.getHourOfDay() < 10 || workTime.getHourOfDay() > 18) {
                                throw new IllegalStateException("Date conversion failed: orig " + dateTime + " work " + workTime);
                            }
                            
                            order.time = workTime.toDateTime().toDate();
                            batch.add(order);
                            if (batch.size() >= 1000) {
                                dataInitializerRepository.batchInsert(batch);
                                batch = new ArrayList<TradeOrder>();
                                System.out.print(".");
                            }
                        }
                        System.out.print("\n");
                    }
                });
            }
            executor.shutdown();
            executor.awaitTermination(20, TimeUnit.MINUTES);
            logger.info("Data populated OK in " + (System.currentTimeMillis() - time));
        } else {
            logger.info("Data exists, no need to populate!");
        }
    }


}
