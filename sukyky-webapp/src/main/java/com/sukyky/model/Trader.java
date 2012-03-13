package com.sukyky.model;

import javax.persistence.Entity;
import java.util.List;

/**
 * @author huljas
 */
@Entity
public class Trader {
    
    public String name;

    public List<Order> orders;
}
