package br.com.anderson17ads.brazilbank.adapters.inbound.controllers;

import br.com.anderson17ads.brazilbank.adapters.inbound.dto.customer.CustomerRequest;
import br.com.anderson17ads.brazilbank.adapters.inbound.dto.customer.CustomerResponse;
import br.com.anderson17ads.brazilbank.adapters.inbound.mapper.CustomerMapper;
import br.com.anderson17ads.brazilbank.adapters.inbound.paths.ApiPaths;
import br.com.anderson17ads.brazilbank.application.usecase.customer.create.CreateCustomerUseCase;
import br.com.anderson17ads.brazilbank.application.usecase.customer.list.ListCustomerUserCase;
import br.com.anderson17ads.brazilbank.domain.customer.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RequestMapping(ApiPaths.CUSTOMER)
@RestController
public class CustomerController {
    private final CreateCustomerUseCase createCustomerUseCase;
    private final ListCustomerUserCase listCustomerUserCase;

    public CustomerController(
            CreateCustomerUseCase createCustomerUseCase,
            ListCustomerUserCase listCustomerUserCase
    ) {
        this.createCustomerUseCase = createCustomerUseCase;
        this.listCustomerUserCase = listCustomerUserCase;
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> create(@Valid @RequestBody CustomerRequest request) {
        Customer created = createCustomerUseCase.execute(
                CustomerMapper.toCommand(request)
        );

        URI location = URI.create(String.format("%s/%s",
                ApiPaths.CUSTOMER,
                created.getId()
        ));

        return ResponseEntity
                .created(location)
                .body(CustomerMapper.toResponse(created));
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> list() {
        List<CustomerResponse> response = CustomerMapper.toResponseList(
                listCustomerUserCase.execute()
        );

        return ResponseEntity.ok(response);
    }
}
