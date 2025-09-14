package br.com.anderson17ads.brazilbank.adapters.inbound.mapper;

import br.com.anderson17ads.brazilbank.adapters.inbound.dto.account.AccountRequest;
import br.com.anderson17ads.brazilbank.adapters.inbound.dto.account.AccountResponse;
import br.com.anderson17ads.brazilbank.application.command.account.CreateAccountCommand;
import br.com.anderson17ads.brazilbank.domain.account.Account;
import br.com.anderson17ads.brazilbank.domain.account.AccountType;

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

    public static CreateAccountCommand toCommand(AccountRequest request) {
        return new CreateAccountCommand(
                request.getBalance(),
                request.getCustomerId(),
                AccountType.valueOf(request.getType())
        );
    }
}
