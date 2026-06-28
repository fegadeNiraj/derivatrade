package com.capitalmarkets.derivatrade.trader.generator;

import com.capitalmarkets.derivatrade.trader.repository.TraderSequenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.Year;

@Component
@RequiredArgsConstructor
public class TradingAccountNumberGeneratorImpl implements TradingAccountNumberGenerator{

    private final TraderSequenceRepository traderSequenceRepository;
    private static final String PREFIX = "TRD";

    private static final int SEQUENCE_LENGTH = 6;

    private static final String ACCOUNT_NUMBER_FORMAT = "%s-%d-%0" + SEQUENCE_LENGTH + "d";


    @Override
    public String generateTradingAccountNumber() {

        long sequence = traderSequenceRepository.getNextTradingAccountSequence();
        int year = Year.now().getValue();

        return String.format(
                ACCOUNT_NUMBER_FORMAT,
                PREFIX,
                year,
                sequence
        );
    }
}
