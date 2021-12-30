package com.ac.learn.rabbitmq.learnrabbitmq.sender.sum;

import com.ac.learn.rabbitmq.learnrabbitmq.sender.sum.model.SumQueueDataModel;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

@Component
public class SumQueueSender {

    @Autowired
    private Queue sumQueue;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public Double send(SumQueueDataModel data) {
        return rabbitTemplate.convertSendAndReceiveAsType(this.sumQueue.getName(), data, new ParameterizedTypeReference<>() {});
    }
}
