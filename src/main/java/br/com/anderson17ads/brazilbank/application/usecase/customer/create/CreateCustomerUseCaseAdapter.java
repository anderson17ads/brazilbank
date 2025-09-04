package br.com.anderson17ads.brazilbank.application.usecase.customer.create;

import br.com.anderson17ads.brazilbank.application.command.customer.CreateCustomerCommand;
import br.com.anderson17ads.brazilbank.domain.customer.Customer;
import br.com.anderson17ads.brazilbank.domain.customer.CustomerFactory;
import br.com.anderson17ads.brazilbank.domain.customer.CustomerRepository;

public class CreateCustomerUseCaseAdapter implements CreateCustomerUseCase {
    private final CustomerRepository customerRepository;
    private final CustomerFactory customerFactory;

    public CreateCustomerUseCaseAdapter(
            CustomerRepository customerRepository,
            CustomerFactory customerFactory
    ) {
        this.customerRepository = customerRepository;
        this.customerFactory = customerFactory;
    }

    @Override
    public Customer execute(CreateCustomerCommand command) {
        Customer customer = customerFactory.create(
                command.getName(),
                command.getEmail(),
                command.getDocument(),
                command.getPhone(),
                command.getBirthDate()
        );

        return customerRepository.save(customer);
    }
}
