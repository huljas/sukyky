package com.sukyky.service;

import com.sukyky.model.*;

import java.util.Date;
import java.util.List;

public interface StockService {

    public List<Stock> findAllStocks();

    Stock getStock(Long id);

    int getOpeningPrice(Stock stock);

    int getClosingPrice(Stock stock);

    int getLastPrice(Stock stock);

    Date getLastTime(Stock stock);
}
