package com.capitalmarkets.derivatrade.entity;


import com.capitalmarkets.derivatrade.enums.QuoteStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "quotes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "instrument_id", nullable = false)
    private Instrument instrument;

    @ManyToOne
    @JoinColumn(name = "market_maker_id", nullable = false)
    private MarketMaker marketMaker;

    @NotNull
    private BigDecimal bidPrice;

    @NotNull
    private BigDecimal askPrice;

    @NotNull
    @Positive
    private Integer originalQuantity;

    @NotNull
    @PositiveOrZero
    private Integer remainingQuantity;

    @NotNull
    @Future
    private LocalDateTime expiryTime;

    @NotNull
    @Enumerated(EnumType.STRING)
    private QuoteStatus status;

}
