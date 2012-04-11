package com.sukyky.service;

import com.sukyky.jamon.aspect.Jamon;
import com.sukyky.model.Stock;
import com.sukyky.model.Trade;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Jamon("Service")
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StatisticsServiceBean implements StatisticsService {

    private static final Logger logger = LoggerFactory.getLogger(StatisticsServiceBean.class);

    @Autowired
    private StockRepository stockRepository;

    public int getDailyMin(final Stock stock) {
        Trade order = stockRepository.getLastTrade(stock.id);
        LocalDate localDate = new LocalDate(order.time);
        Date start = localDate.minusDays(1).toDateTimeAtStartOfDay().toDate();
        return stockRepository.getMin(stock.id, start);

    }

    public int getDailyMax(final Stock stock) {
        Trade order = stockRepository.getLastTrade(stock.id);
        LocalDate localDate = new LocalDate(order.time);
        Date start = localDate.minusDays(1).toDateTimeAtStartOfDay().toDate();
        return stockRepository.getMax(stock.id, start);

    }

    public int getYearlyMin(final Stock stock) {
        Trade order = stockRepository.getLastTrade(stock.id);
        LocalDate localDate = new LocalDate(order.time);
        Date start = localDate.minusDays(365).toDateTimeAtStartOfDay().toDate();
        return stockRepository.getMin(stock.id, start);

    }

    public int getYearlyMax(final Stock stock) {
        Trade order = stockRepository.getLastTrade(stock.id);
        LocalDate localDate = new LocalDate(order.time);
        Date start = localDate.minusDays(365).toDateTimeAtStartOfDay().toDate();
        return stockRepository.getMax(stock.id, start);

    }

}
