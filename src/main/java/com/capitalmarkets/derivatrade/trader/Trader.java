package com.capitalmarkets.derivatrade.trader;

import com.capitalmarkets.derivatrade.common.audit.BaseEntity;
import com.capitalmarkets.derivatrade.common.enums.TraderStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;


@Entity
@Table(name = "traders",
        uniqueConstraints = {
        @UniqueConstraint(name = "uk_trader_email", columnNames = "email"),
                @UniqueConstraint(name = "uk_trader_account_number", columnNames = "trading_account_number"),
                @UniqueConstraint(name = "uk_trader_contact_number", columnNames = "contact_number")
})
@Getter
@Setter
@NoArgsConstructor
public class Trader extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String fullName;

    @Email
    @NotBlank
    @Column(nullable = false, length = 100)
    private String email;

    @NotBlank
    @Pattern(regexp = "^[6-9]\\d{9}$")
    @Column(name = "contact_number", nullable = false, length = 10)
    private String contactNumber;

    @NotBlank
    @Column(name = "trading_account_number", nullable = false, length = 20, updatable = false)
    private String tradingAccountNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private TraderStatus status = TraderStatus.PENDING_VERIFICATION;
}
