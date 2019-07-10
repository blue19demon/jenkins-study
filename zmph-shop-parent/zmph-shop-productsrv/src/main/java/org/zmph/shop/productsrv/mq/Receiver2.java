package org.zmph.shop.productsrv.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic_messages")
public class Receiver2 {
 
    @RabbitHandler
    public void process(String hello){
        System.out.println("Receiver2:" + hello);
    }
}