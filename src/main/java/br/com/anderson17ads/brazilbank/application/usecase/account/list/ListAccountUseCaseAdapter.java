package br.com.anderson17ads.brazilbank.application.usecase.account.list;

import br.com.anderson17ads.brazilbank.domain.account.Account;
import br.com.anderson17ads.brazilbank.domain.account.AccountRepository;

import java.util.List;

public class ListAccountUseCaseAdapter implements ListAccountUseCase {
    AccountRepository accountRepository;

    public ListAccountUseCaseAdapter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> execute() {
        return accountRepository.findAll();
    }
}
