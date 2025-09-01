package br.com.anderson17ads.brazilbank.application.usecase.account;

import br.com.anderson17ads.brazilbank.domain.account.Account;
import br.com.anderson17ads.brazilbank.domain.account.AccountFactory;
import br.com.anderson17ads.brazilbank.domain.account.AccountRepository;
import br.com.anderson17ads.brazilbank.application.command.account.CreateAccountCommand;

public class CreateAccountUseCaseAdapter implements CreateAccountUseCase {
    private final AccountRepository accountRepository;
    private final AccountFactory accountFactory;

    public CreateAccountUseCaseAdapter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        this.accountFactory = new AccountFactory();
    }

    @Override
    public Account execute(CreateAccountCommand command) {
        String number = "1223131232132131232";

        Account account = accountFactory.create(
                number,
                command.getBalance(),
                command.getCustomerId(),
                command.getType()
        );

        return accountRepository.save(account);
    }
}
