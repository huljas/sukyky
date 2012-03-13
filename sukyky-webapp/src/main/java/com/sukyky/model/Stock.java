package com.sukyky.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author huljas
 */
@Entity
public class Stock {

    @Id
    public Long id;

    @Column(unique = true)
    public String name;

    public List<Order> orders;

}
