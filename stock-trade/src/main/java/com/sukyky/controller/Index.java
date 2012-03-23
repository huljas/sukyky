package com.sukyky.controller;

import com.sukyky.model.Stock;
import com.sukyky.repository.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class Index {
	
    private static final Logger logger = LoggerFactory.getLogger(Index.class);
    
    @Autowired
    private StockHelper stockHelper;

    @Autowired
    private StockRepository stockRepository;


    @RequestMapping("/")
	public String show(Model model) {
        List<Stock> stocks = stockRepository.findAllStocks();		

        model.addAttribute("stocks", stocks);
        model.addAttribute("stockHelper", stockHelper);

        return "index";
	}

}
