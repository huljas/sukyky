package com.sukyky.model;

import com.sukyky.repository.StockRepository;

import java.util.Date;

/**
 * Helper class user for rendering the stock data in the template.
 */
public class StockView {

    public Stock stock;

    public StockRepository stockRepository;

    public StockView(Stock stock, StockRepository stockRepository) {
        this.stock = stock;
        this.stockRepository = stockRepository;
    }

    public int getOpeningPrice() {
        return stockRepository.getOpeningPrice(stock);
    }

    public int getClosingPrice() {
        return stockRepository.getClosingPrice(stock);
    }

    public int getLastPrice() {
        return stockRepository.getLastPrice(stock);
    }

    public Date getLastTime() {
        return stockRepository.getLastTime(stock);
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
        return stockRepository.getDailyMin(stock);
    }

    public int getDailyMax() {
        return stockRepository.getDailyMax(stock);
    }

    public int getYearlyMin() {
        return stockRepository.getYearlyMin(stock);
    }

    public int getYearlyMax() {
        return stockRepository.getYearlyMax(stock);
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
