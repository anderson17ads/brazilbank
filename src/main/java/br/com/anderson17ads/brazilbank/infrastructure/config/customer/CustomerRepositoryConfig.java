package br.com.anderson17ads.brazilbank.infrastructure.config.customer;

import br.com.anderson17ads.brazilbank.adapters.outbound.repositories.customer.JpaCustomerRepository;
import br.com.anderson17ads.brazilbank.adapters.outbound.repositories.customer.JpaCustomerRepositoryAdapter;
import br.com.anderson17ads.brazilbank.domain.customer.CustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerRepositoryConfig {
    @Bean
    public CustomerRepository customerRepository(JpaCustomerRepository jpaCustomerRepository) {
        return new JpaCustomerRepositoryAdapter(jpaCustomerRepository);
    }
}
