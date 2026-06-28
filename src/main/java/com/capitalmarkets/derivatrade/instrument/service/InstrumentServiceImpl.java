package com.capitalmarkets.derivatrade.instrument.service;

import com.capitalmarkets.derivatrade.common.enums.InstrumentStatus;
import com.capitalmarkets.derivatrade.common.exception.DuplicateResourceFoundException;
import com.capitalmarkets.derivatrade.instrument.Instrument;
import com.capitalmarkets.derivatrade.instrument.dto.request.CreateInstrumentRequest;
import com.capitalmarkets.derivatrade.instrument.dto.response.InstrumentResponse;
import com.capitalmarkets.derivatrade.instrument.mapper.InstrumentMapper;
import com.capitalmarkets.derivatrade.instrument.repository.InstrumentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InstrumentServiceImpl implements InstrumentService{

    private final InstrumentRepository instrumentRepository;

    private final InstrumentMapper instrumentMapper;

    @Override
    @Transactional
    public InstrumentResponse createInstrument(CreateInstrumentRequest request) {
        if(instrumentRepository.existsBySymbol(request.symbol()))
        {
            throw new DuplicateResourceFoundException(
                    "INSTRUMENT_SYMBOL_ALREADY_EXISTS",
                    "A instrument with a symbol already exists: "+request.symbol()
            );
        }

        InstrumentStatus status = InstrumentStatus.ACTIVE;
        Instrument instrument = instrumentMapper.toEntity(request,status);
        Instrument savedInstrument = instrumentRepository.save(instrument);

        return instrumentMapper.toResponse(savedInstrument);
    }
}
