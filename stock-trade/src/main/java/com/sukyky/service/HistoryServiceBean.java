package com.sukyky.service;

import com.sukyky.model.StockHistory;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class HistoryServiceBean implements HistoryService {

    @Autowired
    private StockRepository stockRepository;

    // Caching the history object should save us some time!
    @Cacheable("long")
    public StockHistory findHistory(Long id, Date since) {
        LocalDate end = new LocalDate();
        LocalDate start = new LocalDate(since);
        Object[] history = stockRepository.findHistory(id, start.toDateTimeAtStartOfDay().toDate(), end.toDateTimeAtStartOfDay().toDate());
        return new StockHistory(history);
    }
}
