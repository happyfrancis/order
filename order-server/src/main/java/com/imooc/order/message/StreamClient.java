package com.imooc.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @program: order
 * @description:
 * @author: Francis
 * @create: 2018-04-24 15:42
 **/
public interface StreamClient {

    String INPUT = "input";

    String OUTPUT = "output";

    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Output(StreamClient.OUTPUT)
    MessageChannel output();
}
