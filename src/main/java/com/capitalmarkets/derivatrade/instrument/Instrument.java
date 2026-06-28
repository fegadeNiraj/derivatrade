package com.capitalmarkets.derivatrade.instrument;

import com.capitalmarkets.derivatrade.common.audit.BaseEntity;
import com.capitalmarkets.derivatrade.common.enums.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "instruments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Instrument extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    private UUID id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String symbol;

    @NotBlank
    @Column(nullable = false, length = 40)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 20)
    private Exchange exchange;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 3)
    private Currency currency;

    @Positive
    @Column(nullable = false, precision = 10, scale = 4)
    private BigDecimal tickSize;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private InstrumentStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 20)
    private AssetClass assetClass;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InstrumentType instrumentType;

}
