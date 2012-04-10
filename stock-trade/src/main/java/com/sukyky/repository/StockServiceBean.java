package com.sukyky.repository;

import com.sukyky.jamon.aspect.Jamon;
import com.sukyky.model.Stock;
import com.sukyky.model.StockHistory;
import com.sukyky.model.Trade;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Jamon("Service")
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StockServiceBean implements StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> findAllStocks() {
        return stockRepository.findAllStocks();
    }

    public Stock getStock(Long id) {
        return stockRepository.getStock(id);
    }

    public int getOpeningPrice(Stock stock) {
        Trade last = stockRepository.getLastTrade(stock.id);
        Date since = new LocalDate(last.time).toDateTimeAtStartOfDay().toDate();
        Trade opening = stockRepository.getFirstTradeAfter(stock.id, since);
        return opening.price;
    }

    public int getClosingPrice(Stock stock) {
        Trade last = stockRepository.getLastTrade(stock.id);
        Date since = new LocalDate(last.time).toDateTimeAtStartOfDay().toDate();
        Trade closing = stockRepository.getLastTradeBefore(stock.id, since);
        return closing.price;
    }

    public int getLastPrice(Stock stock) {
        return stockRepository.getLastTrade(stock.id).price;
    }

    @Cacheable("stockService")
    public StockHistory findHistory(Long id, Date since) {
        LocalDate end = new LocalDate();
        LocalDate start = new LocalDate(since);
        Object[] history = stockRepository.findHistory(id, start.toDateTimeAtStartOfDay().toDate(), end.toDateTimeAtStartOfDay().toDate());
        return new StockHistory(history);
    }

    public int getDailyMin(Stock stock) {
        Trade order = stockRepository.getLastTrade(stock.id);
        Date start = minusDays(order.time, 1);
        return stockRepository.getMin(stock.id, start);
    }

    public int getDailyMax(Stock stock) {
        Trade order = stockRepository.getLastTrade(stock.id);
        Date start = minusDays(order.time, 1);
        return stockRepository.getMax(stock.id, start);
    }

    public int getYearlyMin(Stock stock) {
        Trade order = stockRepository.getLastTrade(stock.id);
        Date start = minusDays(order.time, 365);
        return stockRepository.getMin(stock.id, start);
    }

    public int getYearlyMax(Stock stock) {
        Trade order = stockRepository.getLastTrade(stock.id);
        Date start = minusDays(order.time, 365);
        return stockRepository.getMax(stock.id, start);
    }

    public Date getLastTime(Stock stock) {
        return stockRepository.getLastTrade(stock.id).time;
    }

    public static Date minusDays(Date now, int days) {
        Calendar last = Calendar.getInstance();
        last.setTime(now);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, last.get(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.MONTH, last.get(Calendar.MONTH));
        calendar.set(Calendar.YEAR, last.get(Calendar.YEAR));
        calendar.add(Calendar.DAY_OF_MONTH, -1*days);
        return calendar.getTime();
    }
}
