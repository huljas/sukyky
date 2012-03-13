package com.sukyky.model;

import javax.persistence.Entity;

/**
 * @author huljas
 */
@Entity
public class Order {

    public int amount;
    public int priceA;
    public Trader seller;
    public Trader buyer;
    public Stock stock;
}
