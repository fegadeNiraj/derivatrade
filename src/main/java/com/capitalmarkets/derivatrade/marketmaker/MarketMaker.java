package com.capitalmarkets.derivatrade.marketmaker;

import com.capitalmarkets.derivatrade.common.audit.BaseEntity;
import com.capitalmarkets.derivatrade.common.enums.MarketMakerStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "market_makers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MarketMaker extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true, length = 20)
    private String code;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private MarketMakerStatus status;
}
