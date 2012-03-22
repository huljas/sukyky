package com.sukyky.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author huljas
 */
@Entity
public class TradeOrder {

    @Id @GeneratedValue
    public Long id;
    
    public int priceA;

    @Temporal(value = TemporalType.TIMESTAMP)
    public Date time;

    @ManyToOne(cascade = CascadeType.ALL)
    public Trader seller;
    @ManyToOne(cascade = CascadeType.ALL)
    public Trader buyer;
    @ManyToOne
    public Stock stock;
}
