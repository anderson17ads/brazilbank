package br.com.anderson17ads.brazilbank.adapters.inbound.controllers;

import br.com.anderson17ads.brazilbank.adapters.inbound.dto.customer.CustomerRequest;
import br.com.anderson17ads.brazilbank.adapters.inbound.dto.customer.CustomerResponse;
import br.com.anderson17ads.brazilbank.adapters.inbound.mapper.CustomerMapper;
import br.com.anderson17ads.brazilbank.adapters.inbound.paths.ApiPaths;
import br.com.anderson17ads.brazilbank.application.usecase.customer.create.CreateCustomerUseCase;
import br.com.anderson17ads.brazilbank.application.usecase.customer.list.ListCustomerUseCase;
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
    private final ListCustomerUseCase listCustomerUseCase;

    public CustomerController(
            CreateCustomerUseCase createCustomerUseCase,
            ListCustomerUseCase listCustomerUseCase
    ) {
        this.createCustomerUseCase = createCustomerUseCase;
        this.listCustomerUseCase = listCustomerUseCase;
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
    public ResponseEntity<List<CustomerResponse>> listAll() {
        List<CustomerResponse> response = CustomerMapper.toResponseList(
                listCustomerUseCase.execute()
        );

        return ResponseEntity.ok(response);
    }
}
