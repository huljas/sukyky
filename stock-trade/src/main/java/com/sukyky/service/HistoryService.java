package com.sukyky.service;

import com.sukyky.model.StockHistory;

import java.util.Date;

public interface HistoryService {
    StockHistory findHistory(Long stockId, Date since);
}
