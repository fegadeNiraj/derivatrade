package com.capitalmarkets.derivatrade.trader.service.impl;

import com.capitalmarkets.derivatrade.common.enums.TraderStatus;
import com.capitalmarkets.derivatrade.common.exception.DuplicateResourceFoundException;
import com.capitalmarkets.derivatrade.trader.Trader;
import com.capitalmarkets.derivatrade.trader.dto.request.CreateTraderRequest;
import com.capitalmarkets.derivatrade.trader.dto.response.TraderResponse;
import com.capitalmarkets.derivatrade.trader.generator.TradingAccountNumberGenerator;
import com.capitalmarkets.derivatrade.trader.mapper.TraderMapper;
import com.capitalmarkets.derivatrade.trader.repository.TraderRepository;
import com.capitalmarkets.derivatrade.trader.service.TraderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TraderServiceImpl implements TraderService {

    private final TraderRepository traderRepository;
    private final TradingAccountNumberGenerator tradingAccountNumberGenerator;
    private final TraderMapper traderMapper;

    @Override
    @Transactional
    public TraderResponse createTrader(CreateTraderRequest request) {
        if(traderRepository.existsByEmail(request.getEmail()))
        {
            throw new DuplicateResourceFoundException(
                    "TRADER_EMAIL_ALREADY_EXISTS",
                    "A trader with an email id already exists : " + request.getEmail()
            );
        }

        if(traderRepository.existsByContactNumber(request.getContactNumber()))
        {
            throw new DuplicateResourceFoundException(
                    "TRADER_CONTACTNUMBER_ALREADY_EXISTS",
                    "A trader with an contact number already exists : " + request.getContactNumber()
            );
        }

        String tradingAccountNumber = tradingAccountNumberGenerator.generateTradingAccountNumber();
        TraderStatus status = TraderStatus.PENDING_VERIFICATION;
        Trader trader = traderMapper.toEntity(request,tradingAccountNumber,status);

        Trader savedTrader = traderRepository.save(trader);

        return traderMapper.toResponse(savedTrader);

    }
}
