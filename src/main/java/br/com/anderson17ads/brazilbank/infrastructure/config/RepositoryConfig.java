package br.com.anderson17ads.brazilbank.infrastructure.config;
import br.com.anderson17ads.brazilbank.adapters.outbound.repositories.jpa.JpaAccountRepository;
import br.com.anderson17ads.brazilbank.adapters.outbound.repositories.jpa.JpaAccountRepositoryAdapter;
import br.com.anderson17ads.brazilbank.application.service.AccountService;
import br.com.anderson17ads.brazilbank.application.service.AccountServiceAdapter;
import br.com.anderson17ads.brazilbank.domain.account.AccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {
    @Bean
    public AccountRepository accountRepository(JpaAccountRepository jpaAccountRepository) {
        return new JpaAccountRepositoryAdapter(jpaAccountRepository);
    }

    @Bean
    public AccountService accountService(AccountRepository accountRepository) {
        return new AccountServiceAdapter(accountRepository);
    }
}
