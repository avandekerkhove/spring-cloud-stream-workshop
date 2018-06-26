package com.adeo.devmeetup.scs.demo.orderservice.order;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.MessageChannel;

public interface CustomProcessor extends Processor {

    String OUTPUT_TO_ERROR = "outputToError";

    @Output(CustomProcessor.OUTPUT_TO_ERROR)
    MessageChannel outputToError();
    
}
