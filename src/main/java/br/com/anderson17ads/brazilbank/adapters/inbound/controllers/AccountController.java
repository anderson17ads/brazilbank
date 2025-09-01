package br.com.anderson17ads.brazilbank.adapters.inbound.controllers;

import br.com.anderson17ads.brazilbank.adapters.inbound.dto.account.AccountRequest;
import br.com.anderson17ads.brazilbank.adapters.inbound.dto.account.AccountResponse;
import br.com.anderson17ads.brazilbank.adapters.inbound.paths.ApiPaths;
import br.com.anderson17ads.brazilbank.application.usecase.account.CreateAccountUseCase;
import br.com.anderson17ads.brazilbank.domain.account.Account;
import br.com.anderson17ads.brazilbank.domain.account.AccountType;
import br.com.anderson17ads.brazilbank.application.command.account.CreateAccountCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RequestMapping(ApiPaths.ACCOUNT)
@RestController
public class AccountController {
    private final CreateAccountUseCase createAccountUseCase;

    public AccountController(CreateAccountUseCase createAccountUseCase) {
        this.createAccountUseCase = createAccountUseCase;
    }

    @PostMapping
    public ResponseEntity<AccountResponse> create(@Valid @RequestBody AccountRequest request) {
        CreateAccountCommand command = new CreateAccountCommand(
                request.getBalance(),
                request.getCustomerId(),
                AccountType.valueOf(request.getType())
        );

        Account created = createAccountUseCase.execute(command);

        URI location = URI.create(String.format("%s/%s", ApiPaths.ACCOUNT, created.getId()));

        return ResponseEntity
            .created(location)
            .body(new AccountResponse(created));
    }
}
