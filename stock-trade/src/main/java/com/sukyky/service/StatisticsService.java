package com.sukyky.service;

import com.sukyky.model.Stock;

public interface StatisticsService {

    int getDailyMin(Stock stock);

    int getDailyMax(Stock stock);

    int getYearlyMin(Stock stock);

    int getYearlyMax(Stock stock);

}
