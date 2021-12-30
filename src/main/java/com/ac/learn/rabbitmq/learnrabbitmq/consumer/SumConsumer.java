package com.ac.learn.rabbitmq.learnrabbitmq.consumer;

import com.ac.learn.rabbitmq.learnrabbitmq.sender.sum.model.SumQueueDataModel;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class SumConsumer {

    @RabbitListener(queues = {"${queue.sum.name}"})
    public Double receive(@Payload SumQueueDataModel data) {
        log.info("Value A: " + data.getA());
        log.info("Value B: " + data.getB());

        Double result = data.getA() * data.getB();

        log.info("Result: " + result);

        return result;
    }
}