package br.com.anderson17ads.brazilbank.application.usecase.customer.create;

import br.com.anderson17ads.brazilbank.application.command.customer.CreateCustomerCommand;
import br.com.anderson17ads.brazilbank.domain.customer.Customer;
import br.com.anderson17ads.brazilbank.domain.customer.CustomerFactory;
import br.com.anderson17ads.brazilbank.domain.customer.CustomerRepository;
import br.com.anderson17ads.brazilbank.domain.customer.policy.CheckCustomerAlreadyExistsByEmailPolicy;

public class CreateCustomerUseCaseAdapter implements CreateCustomerUseCase {
    private final CustomerRepository customerRepository;
    private final CustomerFactory customerFactory;
    private final CheckCustomerAlreadyExistsByEmailPolicy checkCustomerAlreadyExistsByEmailPolicy;

    public CreateCustomerUseCaseAdapter(
            CustomerRepository customerRepository,
            CustomerFactory customerFactory,
            CheckCustomerAlreadyExistsByEmailPolicy checkCustomerAlreadyExistsByEmailPolicy
    ) {
        this.customerRepository = customerRepository;
        this.customerFactory = customerFactory;
        this.checkCustomerAlreadyExistsByEmailPolicy = checkCustomerAlreadyExistsByEmailPolicy;
    }

    @Override
    public Customer execute(CreateCustomerCommand command) {
        checkCustomerAlreadyExistsByEmailPolicy.validate(command.getEmail());

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
