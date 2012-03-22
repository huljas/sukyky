package com.sukyky.setup;

import com.sukyky.model.Stock;
import com.sukyky.model.TradeOrder;
import com.sukyky.model.Trader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

/**
 * @author huljas
 */
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class DataInitializerRepository {

    private static final Logger logger = LoggerFactory.getLogger(DataInitializerRepository.class);

    @PersistenceContext
    private EntityManager em;

    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void populateData(){
        logger.info("Populating trade data!");
        List<Stock> stocks = em.createQuery("select s from Stock s", Stock.class).getResultList();
        List<Trader> traders = em.createQuery("select t from Trader t", Trader.class).getResultList();

        Random random = new Random();

        Map<Stock, Integer> prices = new HashMap<Stock, Integer>();
        for (Stock stock : stocks) {
            prices.put(stock, random.nextInt(500 + 60000));
        }

        for (int i = 0; i < 10000; i++) {
            Trader seller = traders.get(random.nextInt(traders.size()));
            Trader buyer = traders.get(random.nextInt(traders.size()));
            Stock stock = stocks.get(random.nextInt(stocks.size()));
            TradeOrder order = new TradeOrder();
            order.buyer = buyer;
            order.seller = seller;
            order.stock = stock;
            order.priceA = prices.get(stock) + random.nextInt(200) - 100;
            prices.put(stock, order.priceA);
            order.time = new Date(System.currentTimeMillis() - 3*24*60*60*1000L + i * (3*24*60*60*1000L) / 10000L);
            em.persist(order);
        }

        logger.info("Data populated OK!");
    }
}
