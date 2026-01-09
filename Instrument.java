package com.bajaj.trading.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Instrument {
    private String symbol;
    private String exchange;
    private String instrumentType;
    private double lastTradedPrice;
}
