package com.bajaj.trading.repository;

import com.bajaj.trading.model.Trade;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TradeRepository {

    private final List<Trade> trades = new ArrayList<>();

    public void save(Trade trade) {
        trades.add(trade);
    }

    public List<Trade> findAll() {
        return trades;
    }
}
