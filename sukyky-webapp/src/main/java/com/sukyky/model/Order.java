package com.sukyky.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author huljas
 */
@Entity
public class Order {

    @Id @GeneratedValue
    public Long id;
    
    public int amount;
    public int priceA;

    @ManyToOne
    public Trader seller;
    @ManyToOne
    public Trader buyer;
    @ManyToOne
    public Stock stock;
}
