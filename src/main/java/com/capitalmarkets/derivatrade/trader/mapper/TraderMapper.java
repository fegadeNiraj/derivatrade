package com.capitalmarkets.derivatrade.trader.mapper;

import com.capitalmarkets.derivatrade.common.enums.TraderStatus;
import com.capitalmarkets.derivatrade.trader.Trader;
import com.capitalmarkets.derivatrade.trader.dto.request.CreateTraderRequest;
import com.capitalmarkets.derivatrade.trader.dto.response.TraderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TraderMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tradingAccountNumber", source = "tradingAccountNumber")
    @Mapping(target = "status", source = "status")
    Trader toEntity(
            CreateTraderRequest request,
            String tradingAccountNumber,
            TraderStatus status
            );

    TraderResponse toResponse(Trader trader);

}
