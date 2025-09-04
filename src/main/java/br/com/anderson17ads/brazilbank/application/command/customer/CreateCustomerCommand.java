package br.com.anderson17ads.brazilbank.application.command.customer;

import java.time.LocalDate;

public class CreateCustomerCommand {
    private final String name;
    private final String email;
    private final String document;
    private final String phone;
    private final LocalDate birthDate;

    public CreateCustomerCommand(String name, String email, String document, String phone, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.document = document;
        this.phone = phone;
        this.birthDate = birthDate;
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
