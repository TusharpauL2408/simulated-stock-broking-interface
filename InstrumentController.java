package com.bajaj.trading.controller;

import com.bajaj.trading.model.Instrument;
import com.bajaj.trading.service.InstrumentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/instruments")
public class InstrumentController {

    private final InstrumentService service;

    public InstrumentController(InstrumentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Instrument> getInstruments() {
        return service.getAllInstruments();
    }
}
