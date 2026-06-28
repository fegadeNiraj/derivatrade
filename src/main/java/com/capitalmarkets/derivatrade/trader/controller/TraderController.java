package com.capitalmarkets.derivatrade.trader.controller;


import com.capitalmarkets.derivatrade.trader.dto.request.CreateTraderRequest;
import com.capitalmarkets.derivatrade.trader.dto.response.TraderResponse;
import com.capitalmarkets.derivatrade.trader.service.TraderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TraderController {

    private final TraderService traderService;

    @PostMapping("/traders")
    public ResponseEntity<TraderResponse> createTrader(@RequestBody @Valid CreateTraderRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(traderService.createTrader(request));
    }

}
