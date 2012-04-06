package com.sukyky.controller;

import com.sukyky.model.Stock;
import com.sukyky.model.StockView;
import com.sukyky.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huljas
 */
@Controller
public class StockDetails {

    @Autowired
    private StockRepository stockRepository;

    @RequestMapping("/stock/{id}")
    public String stockPage(@PathVariable("id") Long id, Model model) {
        Stock stock = stockRepository.getStock(id);
        model.addAttribute("stock", new StockView(stock, stockRepository));
        return "stockDetails";
    }
    
}
