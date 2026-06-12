package com.mobica.catalog.RabbitMQ;

import lombok.RequiredArgsConstructor;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartProducer {

    private final ProducerTemplate producerTemplate;

    public void sendCartEvent(String message) {
        producerTemplate.sendBody(
                "seda:cart-events",
                message
        );
    }
}