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
public class StockViewHelper {
    
    @Autowired
    private StockRepository stockRepository;

    public StockViewHelper() {
    }

    public String getLastPrice(Stock stock) {
        TradeOrder last = stockRepository.getLastTrade(stock);
        return String.format("%.2f", last.priceA/100f);
    }
    
    public String getChange(Stock stock) {
        TradeOrder last = stockRepository.getLastTrade(stock);
        Date since = new LocalDate(last.time).toDateTimeAtStartOfDay().toDate();
        TradeOrder previous = stockRepository.getLastTradeBefore(stock, since);
        return String.format("%.2f", (last.priceA - previous.priceA) / 100f);
    }
    
    public String getChangePercent(Stock stock) {
        TradeOrder last = stockRepository.getLastTrade(stock);
        Date since = new LocalDate(last.time).toDateTimeAtStartOfDay().toDate();
        TradeOrder previous = stockRepository.getLastTradeBefore(stock, since);
        return String.format("%.2f", (last.priceA - previous.priceA) * 100f / previous.priceA);
    }
    
    public String getChangeCss(Stock stock) {
        if (getChange(stock).startsWith("-")) {
            return "down";
        } else {
            return "up";
        }
    }
    
    public String getRange(Stock stock) {
        int[] range = stockRepository.getMinMax(stock, 1);
        return String.format("%.2f - %.2f", range[0]/(float)100, range[1]/(float)100);
    }
    
    public String getYearRange(Stock stock) {
        int[] range = stockRepository.getMinMax(stock, 52);
        return String.format("%.2f - %.2f", range[0]/(float)100, range[1]/(float)100);
    }
    
    public String getOpeningPrice(Stock stock) {
        TradeOrder last = stockRepository.getLastTrade(stock);
        Date since = new LocalDate(last.time).toDateTimeAtStartOfDay().toDate();
        TradeOrder opening = stockRepository.getFirstTradeAfter(stock, since);
        return String.format("%.2f", last.priceA/(float)100);
    }
    
    public String getClosingPrice(Stock stock) {
        TradeOrder last = stockRepository.getLastTrade(stock);
        Date since = new LocalDate(last.time).toDateTimeAtStartOfDay().toDate();
        TradeOrder previous = stockRepository.getLastTradeBefore(stock, since);
        return String.format("%.2f", previous.priceA/(float)100);
    }
}
