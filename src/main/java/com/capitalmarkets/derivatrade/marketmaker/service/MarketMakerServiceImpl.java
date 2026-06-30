package com.capitalmarkets.derivatrade.marketmaker.service;

import com.capitalmarkets.derivatrade.common.enums.MarketMakerStatus;
import com.capitalmarkets.derivatrade.common.exception.DuplicateResourceFoundException;
import com.capitalmarkets.derivatrade.marketmaker.MarketMaker;
import com.capitalmarkets.derivatrade.marketmaker.dto.request.CreateMarketMakerRequest;
import com.capitalmarkets.derivatrade.marketmaker.dto.response.MarketMakerResponse;
import com.capitalmarkets.derivatrade.marketmaker.mapper.MarketMakerMapper;
import com.capitalmarkets.derivatrade.marketmaker.repository.MarketMakerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class MarketMakerServiceImpl implements MarketMakerService{

    private final MarketMakerRepository marketMakerRepository;
    private final MarketMakerMapper marketMakerMapper;

    @Override
    public MarketMakerResponse createMarketMaker(CreateMarketMakerRequest request) {
        if(marketMakerRepository.existsByCode(request.code()))
        {
            throw new DuplicateResourceFoundException(
                    "MARKET_MAKER_CODE_ALREADY_EXISTS",
                    "Market maker with code: "+request.code()+" is already exists"
            );
        }

        if(marketMakerRepository.existsByName(request.name()))
        {
            throw new DuplicateResourceFoundException(
                    "MARKET_MAKER_ALREADY_EXISTS",
                    "Market maker with name: "+request.name()+" is already exists"
            );
        }
        MarketMakerStatus status = MarketMakerStatus.ACTIVE;
        MarketMaker marketMaker = marketMakerMapper.toEntity(request,status);
        MarketMaker savedMarketMaker = marketMakerRepository.save(marketMaker);

        return marketMakerMapper.toResponse(savedMarketMaker);
    }
}
