package br.com.anderson17ads.brazilbank.application.usecase.account;

import br.com.anderson17ads.brazilbank.domain.account.Account;
import br.com.anderson17ads.brazilbank.domain.account.AccountFactory;
import br.com.anderson17ads.brazilbank.domain.account.AccountRepository;
import br.com.anderson17ads.brazilbank.application.command.account.CreateAccountCommand;
import br.com.anderson17ads.brazilbank.domain.account.policy.AccountNumberPolicy;

public class CreateAccountUseCaseAdapter implements CreateAccountUseCase {
    private final AccountRepository accountRepository;
    private final AccountFactory accountFactory;
    private final AccountNumberPolicy accountNumberPolicy;

    public CreateAccountUseCaseAdapter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        this.accountFactory = new AccountFactory();
        this.accountNumberPolicy = new AccountNumberPolicy();
    }

    @Override
    public Account execute(CreateAccountCommand command) {
        String number = accountNumberPolicy.generate();

        Account account = accountFactory.create(
                number,
                command.getBalance(),
                command.getCustomerId(),
                command.getType()
        );

        return accountRepository.save(account);
    }
}
