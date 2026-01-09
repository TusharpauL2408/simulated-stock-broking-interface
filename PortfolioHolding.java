package com.bajaj.trading.model;

import lombok.Data;

@Data
public class PortfolioHolding {

    private String symbol;
    private int quantity;
    private double averagePrice;
    private double currentValue;
}
