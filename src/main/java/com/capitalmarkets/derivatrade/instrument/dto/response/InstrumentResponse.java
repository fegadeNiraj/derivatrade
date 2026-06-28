package com.capitalmarkets.derivatrade.instrument.dto.response;

import com.capitalmarkets.derivatrade.common.enums.*;

import java.math.BigDecimal;
import java.util.UUID;

public record InstrumentResponse(
        UUID id,

        String symbol,

        String name,

        Exchange exchange,

        Currency currency,

        BigDecimal tickSize,

        InstrumentStatus status,

        AssetClass assetClass,

        InstrumentType instrumentType
) {
}
