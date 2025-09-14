package br.com.anderson17ads.brazilbank.adapters.inbound.controllers;

import br.com.anderson17ads.brazilbank.adapters.inbound.dto.account.AccountRequest;
import br.com.anderson17ads.brazilbank.adapters.inbound.dto.account.AccountResponse;
import br.com.anderson17ads.brazilbank.adapters.inbound.mapper.AccountMapper;
import br.com.anderson17ads.brazilbank.adapters.inbound.paths.ApiPaths;
import br.com.anderson17ads.brazilbank.application.usecase.account.create.CreateAccountUseCase;
import br.com.anderson17ads.brazilbank.domain.account.Account;
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
        Account created = createAccountUseCase.execute(
                AccountMapper.toCommand(request)
        );

        URI location = URI.create(String.format("%s/%s", ApiPaths.ACCOUNT, created.getId()));

        return ResponseEntity
                .created(location)
                .body(AccountMapper.toResponse(created));
    }
}
