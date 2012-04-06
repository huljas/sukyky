package com.sukyky.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author huljas
 */
@Entity
public class Stock {

    @Id @GeneratedValue
    public Long id;

    @Column(unique = true)
    public String name;

    @OneToMany(mappedBy = "stock")
    public Set<Trade> trades = new HashSet<Trade>();

    public Stock(String name) {
        this.name = name;
    }

    public Stock() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Trade> getTrades() {
        return trades;
    }

    public void setTrades(Set<Trade> trades) {
        this.trades = trades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock stock = (Stock) o;

        if (name != null ? !name.equals(stock.name) : stock.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
