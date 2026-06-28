package com.capitalmarkets.derivatrade.trader.generator;

import org.springframework.stereotype.Component;

@Component
public interface TradingAccountNumberGenerator{

    String generateTradingAccountNumber();
}
