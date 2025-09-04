package br.com.anderson17ads.brazilbank.application.command.account;

import br.com.anderson17ads.brazilbank.domain.account.AccountType;

import java.math.BigDecimal;
import java.util.UUID;

public class CreateAccountCommand {
    private final BigDecimal balance;
    private final UUID customerId;
    private final AccountType type;

    public CreateAccountCommand(BigDecimal balance, UUID customerId, AccountType type) {
        this.balance = balance;
        this.customerId = customerId;
        this.type = type;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public AccountType getType() {
        return type;
    }
}
