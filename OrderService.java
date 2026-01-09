package com.bajaj.trading.service;

import com.bajaj.trading.model.Order;
import com.bajaj.trading.repository.OrderRepository;
import org.springframework.stereotype.Service;
import com.bajaj.trading.model.Trade;
import com.bajaj.trading.repository.TradeRepository;

import java.time.LocalDateTime;
import java.util.UUID;


@Service
public class OrderService {

    private final OrderRepository repository;
    private final TradeRepository tradeRepository;

    public OrderService(OrderRepository repository, TradeRepository tradeRepository) {
        this.repository = repository;
        this.tradeRepository = tradeRepository;
    }


    public Order placeOrder(Order order) {

        // 1. Validation
        if (order.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        if ("LIMIT".equalsIgnoreCase(order.getOrderStyle()) && order.getPrice() <= 0) {
            throw new IllegalArgumentException("Price is required for LIMIT orders");
        }

        // 2. Execution logic
        if ("MARKET".equalsIgnoreCase(order.getOrderStyle())) {

            order.setStatus("EXECUTED");

            // 3. Create trade for executed order
            Trade trade = new Trade(
                    UUID.randomUUID().toString(),
                    order.getOrderId(),
                    order.getSymbol(),
                    order.getQuantity(),
                    order.getPrice(),
                    LocalDateTime.now()
            );

            tradeRepository.save(trade);

        } else {
            order.setStatus("PLACED");
        }

        // 4. Save order
        repository.save(order);

        return order;
    }
    public Order getOrderById(String orderId) {
        return repository.findById(orderId);
    }


}
