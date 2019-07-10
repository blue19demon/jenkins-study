package org.zmph.shop.usersrv.mq.demo;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
 
    @Autowired
    private AmqpTemplate rabbitmqTemplate;
 
    public void send(){
        String content = "I am from zmph-shop-usersrv project,hello" + new Date();
        System.out.println("Sender:" +content);
        this.rabbitmqTemplate.convertAndSend("hello", content);
    }
    
    public void sendTopic(){
        String content = "hello i am topic," + new Date();
        this.rabbitmqTemplate.convertAndSend("exchage","topic.message",content);
        this.rabbitmqTemplate.convertAndSend("exchage","topic.messages",content);
    }
}