package com.adeo.devmeetup.scs.demo.orderservice.order;

import java.math.BigDecimal;

public class CreateOrder {

    private String id;
    
    private BigDecimal amount;

    public CreateOrder() {}
    
    public CreateOrder(String id, BigDecimal amount) {
        this.id = id;
        this.amount = amount;
    }

    /**
     * @return the amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
    
}
