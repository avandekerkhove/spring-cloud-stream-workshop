package com.adeo.devmeetup.scs.demo.orderservice.order;

import java.math.BigDecimal;

public class OrderCreated {

    private String id;
    
    private BigDecimal price;

    public OrderCreated(){}
    
    public OrderCreated(String id, BigDecimal price) {
        this.id = id;
        this.price = price;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
}
