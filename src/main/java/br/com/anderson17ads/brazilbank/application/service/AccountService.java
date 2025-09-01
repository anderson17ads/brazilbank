package br.com.anderson17ads.brazilbank.application.service;

import br.com.anderson17ads.brazilbank.adapters.inbound.dto.account.AccountRequest;
import br.com.anderson17ads.brazilbank.domain.account.Account;

public interface AccountService {
    public Account create(AccountRequest request);
}
