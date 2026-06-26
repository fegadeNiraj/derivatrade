package com.capitalmarkets.derivatrade.trader.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTraderRequest {

    @NotBlank
    @Size(max = 100)
    private String fullName;

    @Email
    @NotBlank()
    private String email;

    @NotBlank
    @Pattern(
            regexp = "^[6-9]\\d{9}$",
            message = "Contact number must be a valid 10-digit Indian mobile number"
    )
    private String contactNumber;
}
