package com.ac.learn.rabbitmq.learnrabbitmq.consumer;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class TextConsumer {

    @RabbitListener(queues = {"${queue.text.name}"})
    public void receive(@Payload String simpleText) {
        log.info("Text: " + simpleText);
    }
}