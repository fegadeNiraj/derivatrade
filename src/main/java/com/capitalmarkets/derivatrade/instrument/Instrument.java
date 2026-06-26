package com.capitalmarkets.derivatrade.instrument;

import com.capitalmarkets.derivatrade.common.enums.InstrumentType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "instruments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Instrument {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Column(nullable = false, unique = true, length = 50)
    private String symbol;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InstrumentType instrumentType;

    @Column(nullable = false)
    private LocalDateTime expiryDate;
}
