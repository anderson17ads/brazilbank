package br.com.anderson17ads.brazilbank.domain.customer.policy;

import br.com.anderson17ads.brazilbank.domain.customer.CustomerRepository;

public class CheckCustomerAlreadyExistsByEmailPolicy {
    private final CustomerRepository customerRepository;

    public CheckCustomerAlreadyExistsByEmailPolicy(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void validate(String email) {
       if (customerRepository.existsByEmail(email)) {
           throw new IllegalStateException(
                   String.format("Customer %s already exists!", email)
           );
       }
    }
}
