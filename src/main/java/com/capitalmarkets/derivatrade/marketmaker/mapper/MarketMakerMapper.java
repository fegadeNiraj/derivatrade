package com.capitalmarkets.derivatrade.marketmaker.mapper;

import com.capitalmarkets.derivatrade.common.enums.MarketMakerStatus;
import com.capitalmarkets.derivatrade.marketmaker.MarketMaker;
import com.capitalmarkets.derivatrade.marketmaker.dto.request.CreateMarketMakerRequest;
import com.capitalmarkets.derivatrade.marketmaker.dto.response.MarketMakerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface MarketMakerMapper {

    @Mapping(target = "id", ignore = true)
    MarketMaker toEntity(CreateMarketMakerRequest request, MarketMakerStatus status);

    MarketMakerResponse toResponse(MarketMaker marketMaker);

}
