package com.bajaj.trading.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Order {

    private String orderId = UUID.randomUUID().toString();
    private String symbol;
    private String orderType;   // BUY or SELL
    private String orderStyle;  // MARKET or LIMIT
    private int quantity;
    private double price;
    private String status;      // NEW, PLACED, EXECUTED, CANCELLED
    private LocalDateTime createdAt = LocalDateTime.now();
}
