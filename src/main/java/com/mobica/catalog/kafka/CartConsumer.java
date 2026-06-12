package com.mobica.catalog.kafka;


import lombok.RequiredArgsConstructor;
import org.apache.camel.ProducerTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartConsumer {

    private final ProducerTemplate producerTemplate;

    @RabbitListener(queues = "cart.queue")
    public void consume(String message) {

        System.out.println(
                "EVENTO RECIBIDO DE RABBITMQ -> "
                + message
        );

        producerTemplate.sendBody(
                "direct:sendMail",
                message
        );
    }
}