package com.bajaj.trading.controller;

import com.bajaj.trading.model.Order;
import com.bajaj.trading.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public Order placeOrder(@RequestBody Order order) {
        return service.placeOrder(order);
    }

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable String orderId) {
        return service.getOrderById(orderId);
    }
}
