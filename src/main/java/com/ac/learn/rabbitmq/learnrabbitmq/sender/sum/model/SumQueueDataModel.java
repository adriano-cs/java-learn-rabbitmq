package com.ac.learn.rabbitmq.learnrabbitmq.sender.sum.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SumQueueDataModel implements Serializable {
    private double a;
    private double b;
}
