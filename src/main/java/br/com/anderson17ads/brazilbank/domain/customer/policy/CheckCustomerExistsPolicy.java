package br.com.anderson17ads.brazilbank.domain.customer.policy;

import br.com.anderson17ads.brazilbank.domain.customer.CustomerRepository;

import java.util.UUID;

public class CheckCustomerExistsPolicy {
    private final CustomerRepository customerRepository;

    public CheckCustomerExistsPolicy(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void validate(UUID customerId) {
       if (!customerRepository.existsById(customerId)) {
           throw new IllegalStateException(
                   String.format("Customer %s not exists!", customerId)
           );
       }
    }
}
