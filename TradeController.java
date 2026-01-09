package com.bajaj.trading.controller;

import com.bajaj.trading.model.Trade;
import com.bajaj.trading.repository.TradeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/trades")
public class TradeController {

    private final TradeRepository repository;

    public TradeController(TradeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Trade> getTrades() {
        return repository.findAll();
    }
}
