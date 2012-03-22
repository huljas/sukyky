package com.sukyky.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author huljas
 */
@Entity
public class Trader {

    @Id @GeneratedValue
    public Long id;

    @Column(unique = true)
    public String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    public Set<Holding> holdings = new HashSet<Holding>();

    public Trader(String name) {
        this.name = name;
    }

    public Trader() {
    }

    public void addHolding(Stock stock) {
        holdings.add(new Holding(this, stock));
    }

    public void removeHolding(Stock stock) {
        for (Holding holding : holdings) {
            if (holding.stock.equals(stock)) {
                holding.amount--;
                break;
            }
        }
    }
}
