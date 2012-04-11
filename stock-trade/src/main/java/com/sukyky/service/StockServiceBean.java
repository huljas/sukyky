package com.sukyky.service;

import com.sukyky.model.Stock;
import com.sukyky.model.StockHistory;
import com.sukyky.model.Trade;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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

    public Date getLastTime(Stock stock) {
        return stockRepository.getLastTrade(stock.id).time;
    }
}
