package com.bajaj.trading.service;

import com.bajaj.trading.model.Instrument;
import com.bajaj.trading.repository.InstrumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrumentService {

    private final InstrumentRepository repository;

    public InstrumentService(InstrumentRepository repository) {
        this.repository = repository;
    }

    public List<Instrument> getAllInstruments() {
        return repository.findAll();
    }
}
