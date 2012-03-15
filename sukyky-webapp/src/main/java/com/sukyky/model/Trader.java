package com.sukyky.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author huljas
 */
@Entity
public class Trader {

    @Id
    public Long id;

    @Column(unique = true)
    public String name;

    @OneToMany
    public List<Order> orders;
}
