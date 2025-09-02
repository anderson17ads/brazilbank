package br.com.anderson17ads.brazilbank.domain.customer;

import java.time.LocalDate;
import java.util.UUID;

public class Customer {
    private UUID id;
    private String name;
    private String email;
    private String document;
    private String phone;
    private LocalDate birthDate;

    public Customer() {}

    public Customer(UUID id, String name, String email, String document, String phone, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.document = document;
        this.phone = phone;
        this.birthDate = birthDate;
    }

    public Customer(String name, String email, String document, String phone, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.document = document;
        this.phone = phone;
        this.birthDate = birthDate;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDocument() {
        return document;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
