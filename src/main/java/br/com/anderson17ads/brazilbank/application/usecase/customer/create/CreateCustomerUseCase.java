package br.com.anderson17ads.brazilbank.application.usecase.customer.create;

import br.com.anderson17ads.brazilbank.application.command.customer.CreateCustomerCommand;
import br.com.anderson17ads.brazilbank.domain.customer.Customer;

public interface CreateCustomerUseCase {
    Customer execute(CreateCustomerCommand command);
}