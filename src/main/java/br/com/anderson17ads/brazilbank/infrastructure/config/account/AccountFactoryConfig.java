package br.com.anderson17ads.brazilbank.infrastructure.config.account;

import br.com.anderson17ads.brazilbank.domain.account.AccountFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountFactoryConfig {
    @Bean
    public AccountFactory accountFactory() {
        return new AccountFactory();
    }
}
