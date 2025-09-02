package br.com.anderson17ads.brazilbank.domain.customer;

import java.time.LocalDate;

public class CustomerFactory {
    public Customer create(String name, String email, String document, String phone, LocalDate birthDate) {
        return new Customer(name, email, document, phone, birthDate);
    }
}
