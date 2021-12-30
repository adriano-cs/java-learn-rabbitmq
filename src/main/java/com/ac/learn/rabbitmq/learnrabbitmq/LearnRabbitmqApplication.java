package com.ac.learn.rabbitmq.learnrabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@EnableRabbit
@SpringBootApplication
public class LearnRabbitmqApplication {

	@Value("${queue.text.name}")
	private String textQueueName;

	@Value("${queue.sum.name}")
	private String sumQueueName;

	@Bean
	public Queue textQueue() {
		return new Queue(textQueueName, true);
	}

	@Bean
	public Queue sumQueue() {
		return new Queue(sumQueueName, true);
	}

	@Bean
	public MessageConverter jackson2JsonMessageConverter(){
		return new Jackson2JsonMessageConverter("*");
	}

	public static void main(String[] args) {
		SpringApplication.run(LearnRabbitmqApplication.class, args);
	}

}
