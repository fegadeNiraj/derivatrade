package com.capitalmarkets.derivatrade.trader.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface TraderSequenceRepository {

    long getNextTradingAccountSequence();
}
