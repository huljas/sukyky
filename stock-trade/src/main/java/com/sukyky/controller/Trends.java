package com.sukyky.controller;

import com.sukyky.model.RateHistory;
import com.sukyky.repository.StockRepository;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author huljas
 */
@Controller
public class Trends {

    @Autowired
    private StockRepository stockRepository;

    @RequestMapping("/trends/{id}/small")
    @ResponseBody
    public RateHistory smallTrendImage(@PathVariable("id") Long id) {
        LocalDate start = new LocalDate();
        LocalDate end = start.minusDays(31);
        RateHistory history = stockRepository.findRateHistory(id, start, end);
        return history;
    }
}
