package com.imooc.order.controller;

import com.imooc.order.dto.OrderDto;
import com.imooc.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @program: order
 * @description:
 * @author: Francis
 * @create: 2018-04-24 16:42
 **/
@RestController
public class SendMessageController {

//    @Autowired
//    private StreamClient streamClient;

//    @GetMapping("/sendMessage")
//    public void process(){
//        String message = "now: "+new Date();
//        streamClient.output().send(MessageBuilder.withPayload(message).build());
//    }

    /**
     * 发送orderDto对象
     */
    @GetMapping("/sendMessage")
    public void process() {
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId("123456");
//        streamClient.output().send(MessageBuilder.withPayload(orderDto).build());
    }
}
