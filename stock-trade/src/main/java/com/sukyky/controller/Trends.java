package com.sukyky.controller;

import com.sukyky.jamon.aspect.Jamon;
import com.sukyky.model.StockHistory;
import com.sukyky.repository.StockService;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Jamon("Controller")
public class Trends {

    @Autowired
    private StockService stockService;

    @RequestMapping("/trends/{id}/monthly")
    @ResponseBody
    public StockHistory monthlyTrend(@PathVariable("id") Long id) {
        LocalDate start = new LocalDate();
        LocalDate end = start.minusDays(31);
        StockHistory history = stockService.findHistory(id, start, end);
        return history;
    }

    @RequestMapping("/trends/{id}/yearly")
    @ResponseBody
    public StockHistory yearlyTrend(@PathVariable("id") Long id) {
        LocalDate start = new LocalDate();
        LocalDate end = start.minusDays(365);
        StockHistory history = stockService.findHistory(id, start, end);
        return history;
    }

}
