package com.capitalmarkets.derivatrade.marketmaker.controller;

import com.capitalmarkets.derivatrade.marketmaker.dto.request.CreateMarketMakerRequest;
import com.capitalmarkets.derivatrade.marketmaker.dto.response.MarketMakerResponse;
import com.capitalmarkets.derivatrade.marketmaker.service.MarketMakerService;
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
@RequestMapping("/api/v1/market-makers")
public class MarketMakerController {

    private final MarketMakerService marketMakerService;

    @PostMapping
    public ResponseEntity<MarketMakerResponse> create(@Valid @RequestBody CreateMarketMakerRequest request)
    {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(marketMakerService.createMarketMaker(request));
    }

}
