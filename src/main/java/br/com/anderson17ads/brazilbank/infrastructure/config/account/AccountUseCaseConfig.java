package br.com.anderson17ads.brazilbank.infrastructure.config.account;

import br.com.anderson17ads.brazilbank.application.usecase.account.create.CreateAccountUseCase;
import br.com.anderson17ads.brazilbank.application.usecase.account.create.CreateAccountUseCaseAdapter;
import br.com.anderson17ads.brazilbank.domain.account.AccountFactory;
import br.com.anderson17ads.brazilbank.domain.account.AccountRepository;
import br.com.anderson17ads.brazilbank.domain.account.policy.AccountNumberPolicy;
import br.com.anderson17ads.brazilbank.domain.account.policy.MaxAccountsPerCustomerPolicy;
import br.com.anderson17ads.brazilbank.domain.customer.policy.CheckCustomerExistsByUuidPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountUseCaseConfig {
    @Bean
    public CreateAccountUseCase createAccountUseCase(
            AccountRepository accountRepository,
            AccountFactory accountFactory,
            AccountNumberPolicy accountNumberPolicy,
            CheckCustomerExistsByUuidPolicy checkCustomerExistsByUuidPolicy,
            MaxAccountsPerCustomerPolicy maxAccountsPerCustomerPolicy
    ) {
        return new CreateAccountUseCaseAdapter(
                accountRepository,
                accountFactory,
                accountNumberPolicy,
                checkCustomerExistsByUuidPolicy,
                maxAccountsPerCustomerPolicy
        );
    }
}
