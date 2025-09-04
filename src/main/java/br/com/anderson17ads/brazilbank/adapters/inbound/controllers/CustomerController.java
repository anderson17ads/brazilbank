package br.com.anderson17ads.brazilbank.adapters.inbound.controllers;

import br.com.anderson17ads.brazilbank.adapters.inbound.dto.account.AccountResponse;
import br.com.anderson17ads.brazilbank.adapters.inbound.dto.customer.CustomerRequest;
import br.com.anderson17ads.brazilbank.adapters.inbound.dto.customer.CustomerResponse;
import br.com.anderson17ads.brazilbank.adapters.inbound.paths.ApiPaths;
import br.com.anderson17ads.brazilbank.application.command.customer.CreateCustomerCommand;
import br.com.anderson17ads.brazilbank.application.usecase.customer.create.CreateCustomerUseCase;
import br.com.anderson17ads.brazilbank.domain.customer.Customer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RequestMapping(ApiPaths.CUSTOMER)
@RestController
public class CustomerController {
    private final CreateCustomerUseCase createCustomerUseCase;

    public CustomerController(CreateCustomerUseCase createCustomerUseCase) {
        this.createCustomerUseCase = createCustomerUseCase;
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> create(@Valid @RequestBody CustomerRequest request) {
        CreateCustomerCommand command = new CreateCustomerCommand(
                request.getName(),
                request.getEmail(),
                request.getDocument(),
                request.getPhone(),
                request.getBirthDate()
        );

        Customer created = createCustomerUseCase.execute(command);

        URI location = URI.create(String.format("%s/%s", ApiPaths.CUSTOMER, created.getId()));

        return ResponseEntity
                .created(location)
                .body(new CustomerResponse(created));
    }
}
