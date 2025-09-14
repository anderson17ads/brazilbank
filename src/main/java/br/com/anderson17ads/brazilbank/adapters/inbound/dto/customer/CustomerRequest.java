package br.com.anderson17ads.brazilbank.adapters.inbound.dto.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class CustomerRequest {
    @NotBlank(message = "Name cannot be null")
    private String name;

    @NotBlank(message = "Email cannot be null")
    private String email;

    @NotBlank(message = "Document cannot be null")
    private String document;

    @NotBlank(message = "Phone cannot be null")
    private String phone;

    @NotNull(message = "Birth Date cannot be null")
    @JsonProperty("birth_date")
    private LocalDate birthDate;
}
