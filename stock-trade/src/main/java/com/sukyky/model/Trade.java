package com.sukyky.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author huljas
 */
@Entity
public class Trade {

    @Id @GeneratedValue
    public Long id;
    
    public int price;

    @Temporal(value = TemporalType.TIMESTAMP)
    public Date time;

    @ManyToOne
    public Stock stock;
}
