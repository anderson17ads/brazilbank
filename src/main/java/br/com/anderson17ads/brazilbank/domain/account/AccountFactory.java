package br.com.anderson17ads.brazilbank.domain.account;

import java.math.BigDecimal;
import java.util.UUID;

public class AccountFactory {
    public Account create(String number, BigDecimal balance, UUID customerId, AccountType type) {
        return new Account(number, balance, customerId, type);
    }
}
