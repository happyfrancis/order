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

    String INPUT = "myMessage";

    String INPUT2 = "output";

    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Output(StreamClient.INPUT2)
    MessageChannel output();

//     @Input(StreamClient.INPUT2)
//    SubscribableChannel input2();

//    @Output(StreamClient.INPUT2)
//    MessageChannel output2();
}
