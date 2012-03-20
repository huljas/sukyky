package com.sukyky.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author huljas
 */
@Entity
public class Holding {

    @Id
    @GeneratedValue
    public Long id;

    @ManyToOne
    public Trader owner;
    
    @ManyToOne
    public Stock stock;
    
    public int amount;

    public Holding() {
    }

    public Holding(Trader trader, Stock stock) {
        this.owner = trader;
        this.stock = stock;
    }
}
