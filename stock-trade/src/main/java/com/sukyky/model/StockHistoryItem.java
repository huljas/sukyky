package com.sukyky.model;

import java.util.Date;

/**
 * @author huljas
 */
public class StockHistoryItem {

    public int price;
    public Date time;

    public StockHistoryItem() {
    }

    public StockHistoryItem(int price, Date time) {
        this.price = price;
        this.time = time;
    }
}
