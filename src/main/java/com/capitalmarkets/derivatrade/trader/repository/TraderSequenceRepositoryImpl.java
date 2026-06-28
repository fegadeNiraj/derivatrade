package com.capitalmarkets.derivatrade.trader.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TraderSequenceRepositoryImpl implements TraderSequenceRepository{

    private static final String NEXT_SEQUENCE_SQL =
            "SELECT nextVal('trader_account_number_seq')";

    private final JdbcTemplate jdbcTemplate;

    @Override
    public long getNextTradingAccountSequence() {
        Long sequence = jdbcTemplate.queryForObject(NEXT_SEQUENCE_SQL, Long.class);

        if(sequence==null){
            throw new IllegalStateException(
                    "Failed to fetch next trading account sequence."
            );
        }

        return sequence;
    }
}
