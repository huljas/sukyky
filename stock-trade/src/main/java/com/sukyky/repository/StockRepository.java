package com.sukyky.repository;

import com.sukyky.model.*;
import org.joda.time.LocalDate;

import java.util.Date;
import java.util.List;

/**
 * @author huljas
 */
public interface StockRepository {

    public List<Stock> findAllStocks();

    Stock getStock(Long id);

    StockHistory findHistory(Long stockId, LocalDate start, LocalDate end);

    int getOpeningPrice(Stock stock);

    int getClosingPrice(Stock stock);

    int getLastPrice(Stock stock);

    int getDailyMin(Stock stock);

    int getDailyMax(Stock stock);

    int getYearlyMin(Stock stock);

    int getYearlyMax(Stock stock);

    Date getLastTime(Stock stock);
}
