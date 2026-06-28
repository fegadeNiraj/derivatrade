package com.capitalmarkets.derivatrade.instrument.dto.request;

import com.capitalmarkets.derivatrade.common.enums.AssetClass;
import com.capitalmarkets.derivatrade.common.enums.Currency;
import com.capitalmarkets.derivatrade.common.enums.Exchange;
import com.capitalmarkets.derivatrade.common.enums.InstrumentType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record CreateInstrumentRequest(

        @NotBlank
        @Size(max = 20)
        String symbol,

        @NotBlank
        @Size(max = 100)
        String name,

        @NotNull
        Exchange exchange,

        @NotNull
        Currency currency,

        @NotNull
        @DecimalMin(value = "0.0001")
        BigDecimal tickSize,

        @NotNull
        AssetClass assetClass,

        @NotNull
        InstrumentType instrumentType
) {
}
