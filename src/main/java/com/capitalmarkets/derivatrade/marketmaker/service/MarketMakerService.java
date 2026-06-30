package com.capitalmarkets.derivatrade.marketmaker.service;

import com.capitalmarkets.derivatrade.marketmaker.dto.request.CreateMarketMakerRequest;
import com.capitalmarkets.derivatrade.marketmaker.dto.response.MarketMakerResponse;

public interface MarketMakerService {

    MarketMakerResponse createMarketMaker(CreateMarketMakerRequest request);

}
