package com.sukyky.controller;

import com.sukyky.jamon.aspect.Jamon;
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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Jamon("Controller")
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

        List<StockView> downStocks = new ArrayList<StockView>(stocks);
        Collections.sort(downStocks, new Comparator<StockView>() {
            public int compare(StockView o1, StockView o2) {
                return new Float(o1.getChangePercentage()).compareTo(o2.getChangePercentage());
            }
        });
        downStocks = downStocks.subList(0, 5);

        List<StockView> upStocks = new ArrayList<StockView>(stocks);
        Collections.sort(upStocks, new Comparator<StockView>() {
            public int compare(StockView o1, StockView o2) {
                return new Float(o2.getChangePercentage()).compareTo(o1.getChangePercentage());
            }
        });
        upStocks = upStocks.subList(0, 5);

        model.addAttribute("downStocks", downStocks);
        model.addAttribute("upStocks", upStocks);
        model.addAttribute("allStocks", stocks);

        return "index";
	}

}
