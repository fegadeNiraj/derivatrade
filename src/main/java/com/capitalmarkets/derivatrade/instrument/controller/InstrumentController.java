package com.capitalmarkets.derivatrade.instrument.controller;


import com.capitalmarkets.derivatrade.instrument.dto.request.CreateInstrumentRequest;
import com.capitalmarkets.derivatrade.instrument.dto.response.InstrumentResponse;
import com.capitalmarkets.derivatrade.instrument.service.InstrumentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/instruments")
public class InstrumentController {

    private final InstrumentService instrumentService;

    @PostMapping
    public ResponseEntity<InstrumentResponse> createInstrument(@RequestBody @Valid CreateInstrumentRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(instrumentService.createInstrument(request));
    }

}
