package org.zmph.shop.productsrv.mq.conf;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

	@Bean
	public Queue helloQueue() {
		return new Queue("hello");
	}

	@Bean
	public Queue queueMessage() {
		return new Queue("topic_message");
	}

	@Bean
	public Queue queueMessages() {
		return new Queue("topic_messages");
	}

	@Bean
	public TopicExchange exchange() {
		return new TopicExchange("exchage");
	}
	
    //Direct交换机的绑定
	@Bean
	public Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
		return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
	}

   //Topic交换机的绑定
	@Bean
	public Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
		return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
	}
}