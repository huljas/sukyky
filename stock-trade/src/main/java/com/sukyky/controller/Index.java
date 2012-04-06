package com.sukyky.controller;

import com.sukyky.model.Stock;
import com.sukyky.model.StockView;
import com.sukyky.repository.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Index {
	
    private static final Logger logger = LoggerFactory.getLogger(Index.class);
    
    @Autowired
    private StockRepository stockRepository;

    @RequestMapping("/")
	public String show(Model model) {
        List<Stock> list = stockRepository.findAllStocks();

        List<StockView> stocks = new ArrayList<StockView>();

        for (Stock stock : list) {
            stocks.add(new StockView(stock, stockRepository));
        }

        model.addAttribute("stocks", stocks);
        return "index";
	}

}
