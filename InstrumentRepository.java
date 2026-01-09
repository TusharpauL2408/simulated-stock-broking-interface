package com.bajaj.trading.repository;

import com.bajaj.trading.model.Instrument;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InstrumentRepository {

    private final List<Instrument> instruments = List.of(
            new Instrument("TCS", "NSE", "EQUITY", 3800),
            new Instrument("INFY", "NSE", "EQUITY", 1600),
            new Instrument("HDFC", "NSE", "EQUITY", 2800)
    );

    public List<Instrument> findAll() {
        return instruments;
    }
}
