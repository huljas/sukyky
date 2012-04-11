package com.sukyky.controller;

import com.sukyky.jamon.aspect.Jamon;
import com.sukyky.model.Stock;
import com.sukyky.model.StockView;
import com.sukyky.service.StatisticsService;
import com.sukyky.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Jamon("Controller")
public class StockDetails {

    @Autowired
    private StockService stockService;

    @Autowired
    private StatisticsService statisticsService;

    @RequestMapping("/stock/{id}")
    public String stockPage(@PathVariable("id") Long id, Model model) {
        Stock stock = stockService.getStock(id);
        model.addAttribute("stock", new StockView(stock, stockService, statisticsService));
        return "stockDetails";
    }
    
}
