package br.com.anderson17ads.brazilbank.domain.account.policy;

import br.com.anderson17ads.brazilbank.domain.account.AccountRepository;

import java.util.UUID;

public class MaxAccountsPerCustomerPolicy {
    private static final int MAX_ALLOWED_ACCOUNTS = 3;

    private final AccountRepository accountRepository;

    public MaxAccountsPerCustomerPolicy(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void validate(UUID customerId) {
        long accountCount = accountRepository.countByCustomerId(customerId);

        if (accountCount >= MAX_ALLOWED_ACCOUNTS) {
            throw new IllegalStateException(
                    String.format(
                            "Customer %s already has %d accounts (limit is %d)",
                            customerId,
                            accountCount,
                            MAX_ALLOWED_ACCOUNTS
                    )
            );
        }
    }
}
