package com.bajaj.trading.service;

import com.bajaj.trading.model.PortfolioHolding;
import com.bajaj.trading.model.Trade;
import com.bajaj.trading.repository.TradeRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PortfolioService {

    private final TradeRepository tradeRepository;

    public PortfolioService(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    public List<PortfolioHolding> getPortfolio() {

        Map<String, PortfolioHolding> map = new HashMap<>();

        for (Trade trade : tradeRepository.findAll()) {

            PortfolioHolding holding = map.getOrDefault(trade.getSymbol(), new PortfolioHolding());
            holding.setSymbol(trade.getSymbol());

            int newQty = holding.getQuantity() + trade.getQuantity();
            double totalCost = (holding.getAveragePrice() * holding.getQuantity())
                    + (trade.getPrice() * trade.getQuantity());

            holding.setQuantity(newQty);
            holding.setAveragePrice(totalCost / newQty);
            holding.setCurrentValue(newQty * trade.getPrice());

            map.put(trade.getSymbol(), holding);
        }

        return new ArrayList<>(map.values());
    }
}
