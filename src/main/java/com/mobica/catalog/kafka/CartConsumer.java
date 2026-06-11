package com.mobica.catalog.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CartConsumer {

    @KafkaListener(
            topics = "cart-events",
            groupId = "cart-group"
    )
    public void consume(String message) {

        System.out.println(
                "EVENTO RECIBIDO DE KAFKA -> "
                        + message
        );
    }
}