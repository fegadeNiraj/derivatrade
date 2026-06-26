package com.capitalmarkets.derivatrade.trader.dto.response;

import com.capitalmarkets.derivatrade.common.enums.TraderStatus;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TraderResponse {

    private UUID id;
    private String fullName;
    private String email;
    private String contactNumber;
    private String tradingAccountNumber;
    private TraderStatus status;
}
