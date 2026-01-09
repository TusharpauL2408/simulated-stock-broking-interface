package com.bajaj.trading.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Trade {

    private String tradeId;
    private String orderId;
    private String symbol;
    private int quantity;
    private double price;
    private LocalDateTime tradeTime;
}

