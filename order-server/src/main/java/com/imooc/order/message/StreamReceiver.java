package com.imooc.order.message;

import com.imooc.order.dto.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @program: order
 * @description:
 * @author: Francis
 * @create: 2018-04-24 16:39
 **/
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

//    @StreamListener(StreamClient.INPUT)
//    public void process1(Object message){
//         log.info("StreamReceiver: {}",message);
//    }

    /**
     * 接收orderDto对象  消息
     * @param message
     */
    @StreamListener(StreamClient.INPUT)
    @SendTo(StreamClient.INPUT2)
    public String process1(OrderDto message){
         log.info("StreamReceiver: {}",message);
         return "received.";
    }

    @StreamListener(value = StreamClient.INPUT2)
    public void process2(String message){
         log.info("StreamReceiver2: {}",message);
    }
}
