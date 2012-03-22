package com.sukyky.setup;

import com.sukyky.model.Holding;
import com.sukyky.model.Stock;
import com.sukyky.model.Trader;
import com.sukyky.repository.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

/**
 * @author huljas
 */
public class DataInitializer {

    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);
    
    @Value("classpath:stocks.yaml")
    private Resource stocksFile;
    
    @Autowired
    private StockRepository stockRepository;

    private Stock[] stocks = new Stock[]{
            new Stock("Apple"), new Stock("Google"), new Stock("Nokia"), new Stock("Sampo"), new Stock("Dell"), new Stock("Cisco")
    };

    private Trader[] traders = new Trader[]{
            new Trader("Bob"), new Trader("Bill"), new Trader("George")
    };
    
    private Holding[] holdings = new Holding[]{
            new Holding(traders[0], stocks[0], 100),
            new Holding(traders[0], stocks[1], 50),
            new Holding(traders[1], stocks[2], 1000),
            new Holding(traders[1], stocks[3], 20),
            new Holding(traders[2], stocks[4], 40),
            new Holding(traders[2], stocks[5], 1000),
            new Holding(traders[2], stocks[1], 20)
    };
    
    @PostConstruct
    public void init() throws IOException {
        if (stockRepository.findAllStocks().isEmpty()) {
            populateData();
        }
    }

    @Transactional
    public void populateData(){
        logger.info("Populating stocks");
        for (Stock stock : stocks) {
            stockRepository.save(stock);
        }

        logger.info("Populating traders");
        for (Trader trader : traders) {
            stockRepository.save(trader);
        }

        logger.info("Populating holdings");
        for (Holding holding : holdings) {
            stockRepository.save(holding);
        }

        logger.info("Doing some trading");
        for (int i = 0; i < 100; i++) {
            stockRepository.sell(traders[0], stocks[0], 60000);
        }
        for (int i = 0; i < 100; i++) {
            stockRepository.buy(traders[1], stocks[0], 61000);
        }

        logger.info("Data populated OK!");
    }
}
