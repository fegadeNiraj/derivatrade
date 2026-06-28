package com.capitalmarkets.derivatrade.instrument.service;

import com.capitalmarkets.derivatrade.instrument.dto.request.CreateInstrumentRequest;
import com.capitalmarkets.derivatrade.instrument.dto.response.InstrumentResponse;
import org.springframework.stereotype.Service;

@Service
public interface InstrumentService {

    InstrumentResponse createInstrument(CreateInstrumentRequest request);

}
