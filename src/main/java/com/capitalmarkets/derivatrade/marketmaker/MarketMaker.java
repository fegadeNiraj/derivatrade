package com.capitalmarkets.derivatrade.marketmaker;

import com.capitalmarkets.derivatrade.common.audit.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    @Column(nullable = false, unique = true, length = 100)
    private String marketMakerName;
}
