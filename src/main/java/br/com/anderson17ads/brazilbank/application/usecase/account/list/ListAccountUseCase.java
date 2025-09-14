package br.com.anderson17ads.brazilbank.application.usecase.account.list;

import br.com.anderson17ads.brazilbank.domain.account.Account;

import java.util.List;

public interface ListAccountUseCase {
    public List<Account> execute();
}
