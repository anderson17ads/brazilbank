package br.com.anderson17ads.brazilbank.infrastructure.config.customer;

import br.com.anderson17ads.brazilbank.domain.customer.CustomerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerFactoryConfig {
    @Bean
    public CustomerFactory customerFactory() {
        return new CustomerFactory();
    }
}
