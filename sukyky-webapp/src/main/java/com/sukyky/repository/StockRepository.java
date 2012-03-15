package com.sukyky.repository;

import com.sukyky.model.Stock;

import java.util.List;

/**
 * @author huljas
 */
public interface StockRepository {

    public List<Stock> findAllStocks();

    void save(Stock stock);
}
