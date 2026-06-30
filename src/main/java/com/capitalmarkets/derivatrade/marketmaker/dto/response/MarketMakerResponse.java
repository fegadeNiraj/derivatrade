package com.capitalmarkets.derivatrade.marketmaker.dto.response;

import com.capitalmarkets.derivatrade.common.enums.MarketMakerStatus;

import java.util.UUID;

public record MarketMakerResponse(
        UUID id,
        String code,
        String name,
        MarketMakerStatus status
) {
}
