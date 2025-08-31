package br.com.anderson17ads.brazilbank.adapters.inbound.controllers;

import br.com.anderson17ads.brazilbank.adapters.inbound.dto.account.AccountRequest;
import br.com.anderson17ads.brazilbank.adapters.inbound.dto.account.AccountResponse;
import br.com.anderson17ads.brazilbank.adapters.inbound.paths.ApiPaths;
import br.com.anderson17ads.brazilbank.application.service.AccountService;
import br.com.anderson17ads.brazilbank.domain.account.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RequestMapping(ApiPaths.ACCOUNT)
@RestController
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountResponse> create(@Valid @RequestBody AccountRequest request) {
        Account created = accountService.create(request);
        URI location = URI.create(String.format("%s/%s", ApiPaths.ACCOUNT, created.getId()));

        return ResponseEntity
            .created(location)
            .body(new AccountResponse(created));
    }
}
