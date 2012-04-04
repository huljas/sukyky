package com.sukyky.repository;

import com.sukyky.model.*;
import org.joda.time.LocalDate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author huljas
 */
public interface StockRepository {

    public List<Stock> findAllStocks();

    void save(Stock stock);

    void save(Trader trader);

    void save(Holding holding);

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    TradeOrder buy(Trader buyer, Stock stock, int price);

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    TradeOrder sell(Trader seller, Stock stock, int price);

    TradeOrder getLastTrade(Stock stock);

    TradeOrder getLastTradeBefore(Stock stock, Date date);

    TradeOrder getFirstTradeAfter(Stock stock, Date since);

    Stock getStock(Long id);

    RateHistory findRateHistory(Long stockId, LocalDate start, LocalDate end);

    int[] getMinMax(Stock stock, int days);

}
