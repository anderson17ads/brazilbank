package br.com.anderson17ads.brazilbank.infrastructure.config.account;

import br.com.anderson17ads.brazilbank.domain.account.AccountRepository;
import br.com.anderson17ads.brazilbank.domain.account.policy.AccountNumberPolicy;
import br.com.anderson17ads.brazilbank.domain.account.policy.MaxAccountsPerCustomerPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountPolicyConfig {
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
