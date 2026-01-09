package com.bajaj.trading.repository;

import com.bajaj.trading.model.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderRepository {

    private final Map<String, Order> orderStore = new HashMap<>();

    public void save(Order order) {
        orderStore.put(order.getOrderId(), order);
    }

    public Order findById(String orderId) {
        return orderStore.get(orderId);
    }
}
