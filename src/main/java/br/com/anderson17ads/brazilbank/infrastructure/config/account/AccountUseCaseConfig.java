package br.com.anderson17ads.brazilbank.infrastructure.config.account;

import br.com.anderson17ads.brazilbank.application.usecase.account.create.CreateAccountUseCase;
import br.com.anderson17ads.brazilbank.application.usecase.account.create.CreateAccountUseCaseAdapter;
import br.com.anderson17ads.brazilbank.domain.account.AccountFactory;
import br.com.anderson17ads.brazilbank.domain.account.AccountRepository;
import br.com.anderson17ads.brazilbank.domain.account.policy.AccountNumberPolicy;
import br.com.anderson17ads.brazilbank.domain.account.policy.MaxAccountsPerCustomerPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountUseCaseConfig {
    @Bean
    public CreateAccountUseCase createAccountUseCase(
            AccountRepository accountRepository,
            AccountFactory accountFactory,
            AccountNumberPolicy accountNumberPolicy,
            MaxAccountsPerCustomerPolicy maxAccountsPerCustomerPolicy
    ) {
        return new CreateAccountUseCaseAdapter(
                accountRepository,
                accountFactory,
                accountNumberPolicy,
                maxAccountsPerCustomerPolicy
        );
    }

    @Bean
    public AccountNumberPolicy accountNumberPolicy() {
        return new AccountNumberPolicy();
    }

    @Bean
    public MaxAccountsPerCustomerPolicy maxAccountsPerCustomerPolicy(
            AccountRepository accountRepository
    ) {
        return new MaxAccountsPerCustomerPolicy(accountRepository);
    }
}
