package com.sukyky.setup;

import com.sukyky.model.Stock;
import com.sukyky.model.Trade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.io.File;
import java.util.*;

/**
 * @author huljas
 */
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class DataInitializerRepository {

    private static final Logger logger = LoggerFactory.getLogger(DataInitializerRepository.class);

    @Autowired
    private DataSource dataSource;

    @PersistenceContext
    private EntityManager em;

    public boolean hasTradeOrders() {
        return !em.createQuery("select to from Trade to", Trade.class).setMaxResults(10).getResultList().isEmpty();
    }
    
    public List<Stock> getStocks() {
        return em.createQuery("select s from Stock s", Stock.class).getResultList();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void batchInsert(List<Trade> trades) {
        for (Trade order : trades) {
            em.persist(order);
        }
    }

    public void loadDataFile(final File file) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        template.update("SET foreign_key_checks = 0");
        template.update("LOAD DATA INFILE '" + file.getAbsolutePath().replace("\\", "/") + "' INTO TABLE trade_order");
        template.update("SET foreign_key_checks = 1");
    }


}
