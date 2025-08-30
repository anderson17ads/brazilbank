package br.com.anderson17ads.brazilbank.application.service;

import br.com.anderson17ads.brazilbank.adapters.inbound.controllers.dto.AccountRequest;
import br.com.anderson17ads.brazilbank.domain.account.Account;
import br.com.anderson17ads.brazilbank.domain.account.AccountRepository;
import br.com.anderson17ads.brazilbank.domain.account.AccountType;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account create(AccountRequest request) {
        return this.accountRepository.save(new Account(
            request.getNumber(),
            request.getBalance(),
            request.getCustomerId(),
            AccountType.valueOf(request.getType())
        ));
    }
}
