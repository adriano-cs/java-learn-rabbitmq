package com.ac.learn.rabbitmq.learnrabbitmq.sender.text;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TextQueueSender {

    @Autowired
    private Queue textQueue;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String simpleText) {
        rabbitTemplate.convertAndSend(this.textQueue.getName(), simpleText);
    }
}
