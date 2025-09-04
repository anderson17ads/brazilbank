package br.com.anderson17ads.brazilbank.infrastructure.config.customer;

import br.com.anderson17ads.brazilbank.application.usecase.customer.create.CreateCustomerUseCase;
import br.com.anderson17ads.brazilbank.application.usecase.customer.create.CreateCustomerUseCaseAdapter;
import br.com.anderson17ads.brazilbank.domain.customer.CustomerFactory;
import br.com.anderson17ads.brazilbank.domain.customer.CustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerUseCaseConfig {
    @Bean
    public CreateCustomerUseCase createCustomerUseCase(
            CustomerRepository customerRepository,
            CustomerFactory customerFactory
    ) {
        return new CreateCustomerUseCaseAdapter(
                customerRepository,
                customerFactory
        );
    }
}
