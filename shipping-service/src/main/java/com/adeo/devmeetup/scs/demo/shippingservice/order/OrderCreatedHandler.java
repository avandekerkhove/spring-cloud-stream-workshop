package com.adeo.devmeetup.scs.demo.shippingservice.order;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class OrderCreatedHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderCreatedHandler.class.getName());
    
    @StreamListener(Sink.INPUT)
    public void handle(OrderCreated orderCreated) {
        
        LOGGER.info("I received an order !!! " + orderCreated.getId());
        
        // throw exception to see behaviour or rabbitMq
        if (orderCreated.getPrice().compareTo(new BigDecimal("200")) > 0) {
            throw new IllegalArgumentException("Ouch. Too big price for me, sorry");
        }
    }
    
}
