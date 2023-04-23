package com.madhurtoppo.orderservice.controller;

import com.madhurtoppo.domains.entities.Order;
import com.madhurtoppo.domains.entities.OrderEvent;
import com.madhurtoppo.orderservice.kafka.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private OrderProducer producer;

    public OrderController(OrderProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order) {
        order.setId(UUID.randomUUID().toString());

        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("Order status is in pending state.");
        orderEvent.setOrder(order);

        producer.sendMessage(orderEvent);

        return "Order placed successfully.";
    }
}
