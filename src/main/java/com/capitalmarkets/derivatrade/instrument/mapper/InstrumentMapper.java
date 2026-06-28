package com.capitalmarkets.derivatrade.instrument.mapper;

import com.capitalmarkets.derivatrade.common.enums.InstrumentStatus;
import com.capitalmarkets.derivatrade.instrument.Instrument;
import com.capitalmarkets.derivatrade.instrument.dto.request.CreateInstrumentRequest;
import com.capitalmarkets.derivatrade.instrument.dto.response.InstrumentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface InstrumentMapper {

    @Mapping(target = "id", ignore = true)
    Instrument toEntity(CreateInstrumentRequest request, InstrumentStatus status);

    InstrumentResponse toResponse(Instrument instrument);

}
