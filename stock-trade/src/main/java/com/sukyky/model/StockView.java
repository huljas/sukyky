package com.sukyky.model;

import com.sukyky.repository.StockService;

import java.util.Date;

/**
 * Helper class user for rendering the stock data in the template.
 */
public class StockView {

    public Stock stock;

    public StockService stockService;

    public StockView(Stock stock, StockService stockService) {
        this.stock = stock;
        this.stockService = stockService;
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

    public String formatCurrency(int value) {
        return String.format("%.2f", value / 100f);
    }

    public String formatPercentage(float value) {
        return String.format("%.2f", value*100) + " %";
    }

    public String formatTime(Date time) {
        return String.format("%tD %tT", time, time);
    }

    public Long getId() {
        return stock.getId();
    }

    public String getName() {
        return stock.getName();
    }

    public int getDailyMin() {
        return stockService.getDailyMin(stock);
    }

    public int getDailyMax() {
        return stockService.getDailyMax(stock);
    }

    public int getYearlyMin() {
        return stockService.getYearlyMin(stock);
    }

    public int getYearlyMax() {
        return stockService.getYearlyMax(stock);
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
