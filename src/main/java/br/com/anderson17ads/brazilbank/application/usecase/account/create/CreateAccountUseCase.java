package br.com.anderson17ads.brazilbank.application.usecase.account.create;

import br.com.anderson17ads.brazilbank.domain.account.Account;
import br.com.anderson17ads.brazilbank.application.command.account.CreateAccountCommand;

public interface CreateAccountUseCase {
    Account execute(CreateAccountCommand command);
}
