package com.bajaj.trading.controller;

import com.bajaj.trading.model.PortfolioHolding;
import com.bajaj.trading.service.PortfolioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/portfolio")
public class PortfolioController {

    private final PortfolioService service;

    public PortfolioController(PortfolioService service) {
        this.service = service;
    }

    @GetMapping
    public List<PortfolioHolding> getPortfolio() {
        return service.getPortfolio();
    }
}
