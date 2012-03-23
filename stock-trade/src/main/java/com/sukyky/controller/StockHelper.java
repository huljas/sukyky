package com.sukyky.controller;

import com.sukyky.model.Stock;
import com.sukyky.model.TradeOrder;
import com.sukyky.repository.StockRepository;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
* @author huljas
*/
@Component
public class StockHelper {
    
    @Autowired
    private StockRepository stockRepository;

    public StockHelper() {
    }

    public String getLastPrice(Stock stock) {
        TradeOrder last = stockRepository.getLastTrade(stock);
        return String.format("%.2f", last.priceA/100f);
    }
    
    public String getChange(Stock stock) {
        TradeOrder last = stockRepository.getLastTrade(stock);
        Date since = new LocalDate(last.time).toDateTimeAtStartOfDay().toDate();
        TradeOrder previous = stockRepository.getLastTradeSince(stock, since);
        return String.format("%.2f", (last.priceA - previous.priceA) / 100f);
    }
    
    public String getChangePercent(Stock stock) {
        TradeOrder last = stockRepository.getLastTrade(stock);
        Date since = new LocalDate(last.time).toDateTimeAtStartOfDay().toDate();
        TradeOrder previous = stockRepository.getLastTradeSince(stock, since);
        return String.format("%.2f", (last.priceA - previous.priceA) * 100f / previous.priceA);
    }
}
