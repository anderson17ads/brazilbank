package br.com.anderson17ads.brazilbank.domain.account;

import br.com.anderson17ads.brazilbank.adapters.inbound.controllers.dto.AccountRequest;

import java.math.BigDecimal;
import java.util.UUID;

public class Account {
    private UUID id;
    private String number;
    private BigDecimal balance;
    private UUID customerId;
    private AccountType type;

    public Account() {}

    public Account(
        UUID id,
        String number,
        BigDecimal balance,
        UUID customerId,
        AccountType type
    ) {
        this.id = id;
        this.number = number;
        this.balance = balance;
        this.customerId = customerId;
        this.type = type;
    }

    public Account(
        String number,
        BigDecimal balance,
        UUID customerId,
        AccountType type
    ) {
        this.number = number;
        this.balance = balance;
        this.customerId = customerId;
        this.type = type;
    }
    // Id
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    // Number
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    // Balance
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    // CustomerId
    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    // Type
    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }
}
