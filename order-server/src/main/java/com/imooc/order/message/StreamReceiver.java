package com.imooc.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
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

    @StreamListener(StreamClient.INPUT)
    public void process1(Object message){
         log.info("StreamReceiver: {}",message);
    }
}
