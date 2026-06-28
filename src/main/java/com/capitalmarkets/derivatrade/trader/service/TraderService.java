package com.capitalmarkets.derivatrade.trader.service;

import com.capitalmarkets.derivatrade.trader.dto.request.CreateTraderRequest;
import com.capitalmarkets.derivatrade.trader.dto.response.TraderResponse;

public interface TraderService {

    TraderResponse createTrader(CreateTraderRequest request);
}
