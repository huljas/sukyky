package com.sukyky.controller;

import com.sukyky.jamon.aspect.Jamon;
import com.sukyky.model.StockHistory;
import com.sukyky.repository.StockService;
import com.sukyky.repository.StockServiceBean;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;
import java.util.Date;

@Controller
@Jamon("Controller")
public class Trends {

    @Autowired
    private StockService stockService;

    @RequestMapping("/trends/{id}/monthly")
    @ResponseBody
    public StockHistory monthlyTrend(@PathVariable("id") Long id) {
        Date date = new Date();
        Date since = StockServiceBean.minusDays(date, 30);
        StockHistory history = stockService.findHistory(id, since);
        return history;
    }

    @RequestMapping("/trends/{id}/yearly")
    @ResponseBody
    public StockHistory yearlyTrend(@PathVariable("id") Long id) {
        Date date = new Date();
        Date since = StockServiceBean.minusDays(date, 365);
        StockHistory history = stockService.findHistory(id, since);
        return history;
    }

    public static Date minusDays(Date now, int days) {
        Calendar last = Calendar.getInstance();
        last.setTime(now);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, last.get(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.MONTH, last.get(Calendar.MONTH));
        calendar.set(Calendar.YEAR, last.get(Calendar.YEAR));
        calendar.add(Calendar.DAY_OF_MONTH, -1*days);
        return calendar.getTime();
    }

}
