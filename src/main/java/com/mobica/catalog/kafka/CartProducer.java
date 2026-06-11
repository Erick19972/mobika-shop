package com.mobica.catalog.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendCartEvent(String message) {

        kafkaTemplate.send(
                "cart-events",
                message
        );

        System.out.println(
                "EVENTO ENVIADO A KAFKA -> "
                        + message
        );
    }
}