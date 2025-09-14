package br.com.anderson17ads.brazilbank.adapters.inbound.mapper;

import br.com.anderson17ads.brazilbank.adapters.inbound.dto.account.AccountRequest;
import br.com.anderson17ads.brazilbank.adapters.inbound.dto.account.AccountResponse;
import br.com.anderson17ads.brazilbank.application.command.account.CreateAccountCommand;
import br.com.anderson17ads.brazilbank.domain.account.Account;
import br.com.anderson17ads.brazilbank.domain.account.AccountType;

import java.util.List;
import java.util.stream.Collectors;

public class AccountMapper {
    public static AccountResponse toResponse(Account account) {
        if (account == null) {
            return null;
        }

        AccountResponse response = new AccountResponse();
        response.setId(account.getId());
        response.setNumber(account.getNumber());
        response.setBalance(account.getBalance());
        response.setCustomerId(account.getCustomerId());
        response.setType(account.getType());

        return response;
    }

    public static List<AccountResponse> toResponseList(List<Account> accounts) {
        return accounts.stream()
                .map(AccountMapper::toResponse)
                .collect(Collectors.toList());
    }

    public static CreateAccountCommand toCommand(AccountRequest request) {
        return new CreateAccountCommand(
                request.getBalance(),
                request.getCustomerId(),
                AccountType.valueOf(request.getType())
        );
    }
}
