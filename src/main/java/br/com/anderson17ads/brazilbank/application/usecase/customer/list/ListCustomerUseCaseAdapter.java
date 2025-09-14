package br.com.anderson17ads.brazilbank.application.usecase.customer.list;

import br.com.anderson17ads.brazilbank.domain.customer.Customer;
import br.com.anderson17ads.brazilbank.domain.customer.CustomerRepository;

import java.util.List;

public class ListCustomerUseCaseAdapter implements ListCustomerUserCase {
    CustomerRepository customerRepository;

    public ListCustomerUseCaseAdapter(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> execute() {
        return customerRepository.findAll();
    }
}
