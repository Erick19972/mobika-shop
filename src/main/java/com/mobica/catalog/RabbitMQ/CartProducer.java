package com.mobica.catalog.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendCartEvent(String message) {

        rabbitTemplate.convertAndSend(
                "cart.queue",
                message
        );

        System.out.println(
                "EVENTO ENVIADO A RABBITMQ -> " + message
        );
    }
}