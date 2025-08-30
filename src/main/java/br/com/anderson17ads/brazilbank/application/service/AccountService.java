package br.com.anderson17ads.brazilbank.application.service;

import br.com.anderson17ads.brazilbank.domain.account.Account;
import br.com.anderson17ads.brazilbank.domain.account.AccountRepository;
import br.com.anderson17ads.brazilbank.domain.account.AccountType;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public String create(JsonNode data) {
        this.accountRepository.save(new Account(
            data.get("number").asText(),
            new BigDecimal(data.get("balance").asText()),
            UUID.fromString(data.get("customer_id").asText()),
            AccountType.valueOf(data.get("type").asText())
        ));

        return "ok";
    }
}
