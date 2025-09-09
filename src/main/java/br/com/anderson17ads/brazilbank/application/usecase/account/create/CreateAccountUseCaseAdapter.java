package br.com.anderson17ads.brazilbank.application.usecase.account.create;

import br.com.anderson17ads.brazilbank.domain.account.Account;
import br.com.anderson17ads.brazilbank.domain.account.AccountFactory;
import br.com.anderson17ads.brazilbank.domain.account.AccountRepository;
import br.com.anderson17ads.brazilbank.application.command.account.CreateAccountCommand;
import br.com.anderson17ads.brazilbank.domain.account.policy.AccountNumberPolicy;
import br.com.anderson17ads.brazilbank.domain.account.policy.MaxAccountsPerCustomerPolicy;
import br.com.anderson17ads.brazilbank.domain.customer.policy.CheckCustomerExistsPolicy;

public class CreateAccountUseCaseAdapter implements CreateAccountUseCase {
    private final AccountRepository accountRepository;
    private final AccountFactory accountFactory;
    private final AccountNumberPolicy accountNumberPolicy;
    private final CheckCustomerExistsPolicy checkCustomerExistsPolicy;
    private final MaxAccountsPerCustomerPolicy maxAccountsPerCustomerPolicy;

    public CreateAccountUseCaseAdapter(
            AccountRepository accountRepository,
            AccountFactory accountFactory,
            AccountNumberPolicy accountNumberPolicy,
            CheckCustomerExistsPolicy checkCustomerExistsPolicy,
            MaxAccountsPerCustomerPolicy maxAccountsPerCustomerPolicy
    ) {
        this.accountRepository = accountRepository;
        this.accountFactory = accountFactory;
        this.accountNumberPolicy = accountNumberPolicy;
        this.checkCustomerExistsPolicy = checkCustomerExistsPolicy;
        this.maxAccountsPerCustomerPolicy = maxAccountsPerCustomerPolicy;
    }

    @Override
    public Account execute(CreateAccountCommand command) {
        checkCustomerExistsPolicy.validate(command.getCustomerId());
        maxAccountsPerCustomerPolicy.validate(command.getCustomerId());

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
