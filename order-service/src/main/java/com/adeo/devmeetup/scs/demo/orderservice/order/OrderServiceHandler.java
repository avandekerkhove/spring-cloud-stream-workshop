package com.adeo.devmeetup.scs.demo.orderservice.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding(Processor.class)
public class OrderServiceHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceHandler.class.getName());
    
    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public OrderCreated handleOrderCommand(CreateOrder orderCommand) {
        
        LOGGER.info("Hey ! Just received a command createORder : " + orderCommand.getId());
        
        OrderCreated published = new OrderCreated(orderCommand.getId(), orderCommand.getAmount());
        
        LOGGER.info("Publish an OrderCreated event");
        
        return published;
        
    }
    
}
