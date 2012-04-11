package com.sukyky.service;

import com.sukyky.model.Stock;
import com.sukyky.model.Trade;

import java.util.Date;
import java.util.List;

/**
 * @author huljas
 */
public interface StockRepository {
    List<Stock> findAllStocks();

    Stock getStock(Long id);

    Object[] findHistory(Long id, Date start, Date end);

    Trade getLastTrade(Long id);

    Trade getFirstTradeAfter(Long id, Date since);

    Trade getLastTradeBefore(Long id, Date since);

    int getMin(Long id, Date since);

    int getMax(Long id, Date start);
}
