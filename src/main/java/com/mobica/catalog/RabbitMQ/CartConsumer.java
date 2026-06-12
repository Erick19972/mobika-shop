package com.mobica.catalog.RabbitMQ;


import lombok.RequiredArgsConstructor;
import org.apache.camel.Consume;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartConsumer {

    private final ProducerTemplate producerTemplate;

    @Consume("seda:cart-events")
    public void consume(String message) {

        System.out.println(
                "EVENTO RECIBIDO DE SEDA -> "
                        + message
        );

        producerTemplate.sendBody(
                "direct:sendMail",
                message
        );
    }
}