package com.ac.learn.rabbitmq.learnrabbitmq.controller;

import com.ac.learn.rabbitmq.learnrabbitmq.sender.text.TextQueueSender;
import com.ac.learn.rabbitmq.learnrabbitmq.sender.sum.SumQueueSender;
import com.ac.learn.rabbitmq.learnrabbitmq.sender.sum.model.SumQueueDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/test")
public class TestController {

    @Autowired
    private TextQueueSender textQueueSender;

    @Autowired
    private SumQueueSender sumQueueSender;

    @RequestMapping(method= RequestMethod.GET, value="/text")
    public ResponseEntity sendSimpleText(@RequestParam String message) {

        this.textQueueSender.send(message);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method= RequestMethod.GET, value="/sum")
    public ResponseEntity<Double> sendSimpleText(@RequestParam Double a, @RequestParam Double b) {

        Double result = this.sumQueueSender.send(new SumQueueDataModel(a, b));
        return ResponseEntity.ok(result);
    }
}
