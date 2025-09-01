package br.com.anderson17ads.brazilbank.infrastructure.config;

import br.com.anderson17ads.brazilbank.application.usecase.account.CreateAccountUseCase;
import br.com.anderson17ads.brazilbank.application.usecase.account.CreateAccountUseCaseAdapter;
import br.com.anderson17ads.brazilbank.domain.account.AccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
    @Bean
    public CreateAccountUseCase createAccountUseCase(AccountRepository accountRepository) {
        return new CreateAccountUseCaseAdapter(accountRepository);
    }
}
