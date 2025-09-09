package br.com.anderson17ads.brazilbank.infrastructure.config.customer;

import br.com.anderson17ads.brazilbank.domain.customer.CustomerRepository;
import br.com.anderson17ads.brazilbank.domain.customer.policy.CheckCustomerExistsPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerPolicyConfig {
    @Bean
    public CheckCustomerExistsPolicy checkCustomerExistsPolicy(
            CustomerRepository customerRepository
    ) {
        return new CheckCustomerExistsPolicy(customerRepository);
    }
}
