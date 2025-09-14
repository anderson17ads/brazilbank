package br.com.anderson17ads.brazilbank.adapters.inbound.dto.customer;

import br.com.anderson17ads.brazilbank.domain.customer.Customer;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class CustomerResponse {
    private UUID id;
    private String name;
    private String email;
    private String document;
    private String phone;
    private LocalDate birthDate;
}
