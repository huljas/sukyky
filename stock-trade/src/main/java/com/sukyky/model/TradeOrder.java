package com.sukyky.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author huljas
 */
@Entity
@Table(name="trade_order")
public class TradeOrder {

    @Id @GeneratedValue
    public Long id;
    
    public int priceA;

    @Temporal(value = TemporalType.TIMESTAMP)
    public Date time;

    @ManyToOne
    public Trader seller;
    @ManyToOne
    public Trader buyer;
    @ManyToOne
    public Stock stock;
}
