package com.sukyky.model;

import javax.persistence.*;
import java.util.Iterator;
import java.util.List;

/**
 * @author huljas
 */
@Entity
public class Trader {

    @Id @GeneratedValue
    public Long id;

    @Column(unique = true)
    public String name;

    @OneToMany(cascade = CascadeType.ALL)
    public List<Holding> holdings;

    public void addHolding(Stock stock) {
        holdings.add(new Holding(this, stock));
    }

    public void removeHolding(Stock stock) {
        Iterator<Holding> iterator = holdings.iterator();
        for (Holding holding = iterator.next(); iterator.hasNext(); holding = iterator.next()) {
            if (holding.stock.equals(stock)) {
                iterator.remove();
            }
        }
    }
}
