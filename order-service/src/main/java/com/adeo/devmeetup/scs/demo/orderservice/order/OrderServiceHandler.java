package com.adeo.devmeetup.scs.demo.orderservice.order;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(CustomProcessor.class)
public class OrderServiceHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceHandler.class.getName());
    
    @Autowired
    private CustomProcessor processor;
    
    @StreamListener(CustomProcessor.INPUT)
    @SendTo(CustomProcessor.OUTPUT)
    public OrderCreated handleOrderCommand(CreateOrder orderCommand) {
        
        LOGGER.info("Hey ! Just received a command createORder : " + orderCommand.getId());
        
        OrderCreated published = new OrderCreated(orderCommand.getId(), orderCommand.getAmount());
        
        if (published.getPrice().compareTo(new BigDecimal("1000")) > 0) {
            LOGGER.error("Too big amount !! publish an error !");
            processor
                .outputToError()
                .send(MessageBuilder.withPayload(published).build());
            return null;
        }
        else {
            LOGGER.info("Publish an OrderCreated event");
            return published;
        }
    }
    
}
