package com.sukyky.model;

import java.util.Date;

/**
 * @author huljas
 */
public class RateHistoryItem {

    public int price;
    public Date time;

    public RateHistoryItem() {
    }

    public RateHistoryItem(int price, Date time) {
        this.price = price;
        this.time = time;
    }
}
