package com.mobica.catalog.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class PurchaseRoute extends RouteBuilder {

    @Override
    public void configure() {

         /* from("kafka:cart-events")
                .log("CAMEL RECIBIÓ -> ${body}")

                .setHeader("To", constant("franky431216@hotmail.com"))
                .setHeader("Subject", constant("Producto agregado al carrito"))

                .setBody(simple(
                        "Se recibió un evento:\n\n${body}"))

                .to("smtp://{{smtp.host}}:{{smtp.port}}"
                        + "?username={{smtp.username}}"
                        + "&password={{smtp.password}}"
                        + "&mail.smtp.auth=true"
                        + "&mail.smtp.starttls.enable=true");*/
    }
}