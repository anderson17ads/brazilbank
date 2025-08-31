package br.com.anderson17ads.brazilbank.adapters.inbound.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Data
public class AccountRequest {
    @NotBlank(message = "Number cannot be null")
    private String number;

    @NotNull(message = "Balance cannot be null")
    private BigDecimal balance;

    @NotNull(message = "CustumerId cannot be null")
    @JsonProperty("customer_id")
    private UUID customerId;

    @NotBlank(message = "Type cannot be null")
    private String type;
}
