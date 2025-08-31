package br.com.anderson17ads.brazilbank.adapters.inbound.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Data
public class AccountRequest {
    @NotBlank
    private String number;

    @NotNull
    private BigDecimal balance;

    @NotBlank
    @JsonProperty("customer_id")
    private UUID customerId;

    @NotBlank
    private String type;
}
