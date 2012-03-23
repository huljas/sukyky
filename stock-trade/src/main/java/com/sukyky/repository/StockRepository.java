package com.sukyky.repository;

import com.sukyky.model.Holding;
import com.sukyky.model.TradeOrder;
import com.sukyky.model.Stock;
import com.sukyky.model.Trader;
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

    TradeOrder getLastTradeSince(Stock stock, Date date);
}
