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

    public CustomerResponse(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.email = customer.getEmail();
        this.document = customer.getDocument();
        this.phone = customer.getPhone();
        this.birthDate = customer.getBirthDate();
    }
}
