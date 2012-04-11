package com.sukyky.controller;

import com.sukyky.jamon.aspect.Jamon;
import com.sukyky.model.Stock;
import com.sukyky.model.StockView;
import com.sukyky.service.StatisticsService;
import com.sukyky.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Jamon("Controller")
@Controller
public class Index {
	
    private static final Logger logger = LoggerFactory.getLogger(Index.class);
    
    @Autowired
    private StockService stockService;

    @Autowired
    private StatisticsService statisticsService;

    @RequestMapping("/")
	public String show(Model model) {
        List<Stock> list = stockService.findAllStocks();

        List<StockView> stocks = new ArrayList<StockView>();

        for (Stock stock : list) {
            stocks.add(new StockView(stock, stockService, statisticsService));
        }

        List<StockView> downStocks = new ArrayList<StockView>(stocks);
        Collections.sort(downStocks, new Comparator<StockView>() {
            public int compare(StockView o1, StockView o2) {
                return new Float(o1.getChangePercentage()).compareTo(o2.getChangePercentage());
            }
        });

        List<StockView> upStocks = downStocks.subList(downStocks.size() - 5, downStocks.size());
        Collections.reverse(upStocks);
        downStocks = downStocks.subList(0, 5);

        model.addAttribute("downStocks", downStocks);
        model.addAttribute("upStocks", upStocks);
        model.addAttribute("allStocks", stocks);

        return "index";
	}

}
