package com.sukyky.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author huljas
 */
@Entity
public class Stock {

    @Id @GeneratedValue
    public Long id;

    @Column(unique = true)
    public String name;

    @OneToMany
    public List<Order> orders;

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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public int getLastPrice() {
        return 100;
    }

    public int getChange() {
        return 101;
    }

    public int getChangePercentage() {
        return 1;
    }
}
