package br.com.anderson17ads.brazilbank.infrastructure.config.customer;

import br.com.anderson17ads.brazilbank.domain.customer.CustomerRepository;
import br.com.anderson17ads.brazilbank.domain.customer.policy.CheckCustomerAlreadyExistsByEmailPolicy;
import br.com.anderson17ads.brazilbank.domain.customer.policy.CheckCustomerExistsByUuidPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerPolicyConfig {
    @Bean
    public CheckCustomerExistsByUuidPolicy checkCustomerExistsPolicy(
            CustomerRepository customerRepository
    ) {
        return new CheckCustomerExistsByUuidPolicy(customerRepository);
    }

    @Bean
    public CheckCustomerAlreadyExistsByEmailPolicy checkCustomerExistsByEmailPolicy(
            CustomerRepository customerRepository
    ) {
        return new CheckCustomerAlreadyExistsByEmailPolicy(customerRepository);
    }
}
