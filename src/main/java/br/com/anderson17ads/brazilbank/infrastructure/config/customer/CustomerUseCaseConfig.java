package br.com.anderson17ads.brazilbank.infrastructure.config.customer;

import br.com.anderson17ads.brazilbank.application.usecase.customer.create.CreateCustomerUseCase;
import br.com.anderson17ads.brazilbank.application.usecase.customer.create.CreateCustomerUseCaseAdapter;
import br.com.anderson17ads.brazilbank.application.usecase.customer.list.ListCustomerUseCaseAdapter;
import br.com.anderson17ads.brazilbank.application.usecase.customer.list.ListCustomerUseCase;
import br.com.anderson17ads.brazilbank.domain.customer.CustomerFactory;
import br.com.anderson17ads.brazilbank.domain.customer.CustomerRepository;
import br.com.anderson17ads.brazilbank.domain.customer.policy.CheckCustomerAlreadyExistsByEmailPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerUseCaseConfig {
    @Bean
    public CreateCustomerUseCase createCustomerUseCase(
            CustomerRepository customerRepository,
            CustomerFactory customerFactory,
            CheckCustomerAlreadyExistsByEmailPolicy checkCustomerAlreadyExistsByEmailPolicy
    ) {
        return new CreateCustomerUseCaseAdapter(
                customerRepository,
                customerFactory,
                checkCustomerAlreadyExistsByEmailPolicy
        );
    }

    @Bean
    public ListCustomerUseCase listCustomerUseCase(
            CustomerRepository customerRepository
    ) {
        return new ListCustomerUseCaseAdapter(customerRepository);
    }
}
