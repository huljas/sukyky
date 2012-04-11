package com.sukyky.model;

import com.sukyky.service.StatisticsService;
import com.sukyky.service.StockService;

import java.util.Date;

/**
 * Helper class user for rendering the stock data in the template.
 */
public class StockView {

    public Stock stock;

    public StockService stockService;

    public StatisticsService statisticsService;

    public StockView(Stock stock, StockService stockService, StatisticsService statisticsService) {
        this.stock = stock;
        this.stockService = stockService;
        this.statisticsService = statisticsService;
    }

    public int getOpeningPrice() {
        return stockService.getOpeningPrice(stock);
    }

    public int getClosingPrice() {
        return stockService.getClosingPrice(stock);        
    }

    public int getLastPrice() {
        return stockService.getLastPrice(stock);
    }

    public Date getLastTime() {
        return stockService.getLastTime(stock);
    }

    public int getChange() {
        return getLastPrice() - getClosingPrice();
    }

    public float getChangePercentage() {
        return getChange() / (float) getClosingPrice();
    }

    public synchronized String formatCurrency(int value) {
        return String.format("%.2f", value / 100f);
    }

    public synchronized String formatPercentage(float value) {
        return String.format("%.2f", value*100) + " %";
    }

    public synchronized String formatTime(Date time) {
        return String.format("%tD %tT", time, time);
    }

    public Long getId() {
        return stock.getId();
    }

    public String getName() {
        return stock.getName();
    }

    public int getDailyMin() {
        return statisticsService.getDailyMin(stock);
    }

    public int getDailyMax() {
        return statisticsService.getDailyMax(stock);
    }

    public int getYearlyMin() {
        return statisticsService.getYearlyMin(stock);
    }

    public int getYearlyMax() {
        return statisticsService.getYearlyMax(stock);
    }

    public String getChangeDirection() {
        if (getChange() > 0) {
            return "up";
        }
        else if (getChange() < 0) {
            return "down";
        } else {
            return "none";
        }
    }
}
