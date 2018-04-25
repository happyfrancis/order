package com.imooc.order;

import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @program: order
 * @description:
 * @author: Francis
 * @create: 2018-04-24 13:55
 **/
@Component
public class MqReceiverTest extends OrderApplicationTests {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void send(){
        amqpTemplate.convertAndSend("myQueue","now: "+new Date());
    }

    @Test
    public void sendOrder(){
        amqpTemplate.convertAndSend("myOrder","fruit","now: "+new Date());
    }

}
