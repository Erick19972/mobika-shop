package com.mobica.catalog.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue cartQueue() {
        return new Queue("cart.queue", true);
    }
}