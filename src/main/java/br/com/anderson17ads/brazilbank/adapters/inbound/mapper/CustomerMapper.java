package br.com.anderson17ads.brazilbank.adapters.inbound.mapper;

import br.com.anderson17ads.brazilbank.adapters.inbound.dto.customer.CustomerRequest;
import br.com.anderson17ads.brazilbank.adapters.inbound.dto.customer.CustomerResponse;
import br.com.anderson17ads.brazilbank.application.command.customer.CreateCustomerCommand;
import br.com.anderson17ads.brazilbank.domain.customer.Customer;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {
    public static CustomerResponse toResponse(Customer customer) {
        if (customer == null) {
            return null;
        }

        CustomerResponse response = new CustomerResponse();
        response.setId(customer.getId());
        response.setName(customer.getName());
        response.setEmail(customer.getEmail());
        response.setDocument(customer.getDocument());
        response.setPhone(customer.getPhone());
        response.setBirthDate(customer.getBirthDate());

        return response;
    }

    public static List<CustomerResponse> toResponseList(List<Customer> customers) {
        return customers.stream()
                .map(CustomerMapper::toResponse)
                .collect(Collectors.toList());
    }

    public static CreateCustomerCommand toCommand(CustomerRequest request) {
        return new CreateCustomerCommand(
                request.getName(),
                request.getEmail(),
                request.getDocument(),
                request.getPhone(),
                request.getBirthDate()
        );
    }
}
