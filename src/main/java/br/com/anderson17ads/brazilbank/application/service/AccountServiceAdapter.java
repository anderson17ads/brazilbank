package br.com.anderson17ads.brazilbank.application.service;

import br.com.anderson17ads.brazilbank.adapters.inbound.dto.account.AccountRequest;
import br.com.anderson17ads.brazilbank.domain.account.Account;
import br.com.anderson17ads.brazilbank.domain.account.AccountRepository;
import br.com.anderson17ads.brazilbank.domain.account.AccountType;

public class AccountServiceAdapter implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceAdapter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account create(AccountRequest request) {
        return this.accountRepository.save(new Account(
            request.getNumber(),
            request.getBalance(),
            request.getCustomerId(),
            AccountType.valueOf(request.getType())
        ));
    }
}
