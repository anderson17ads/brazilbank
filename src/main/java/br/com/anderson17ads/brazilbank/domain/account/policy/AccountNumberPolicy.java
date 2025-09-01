package br.com.anderson17ads.brazilbank.domain.account.policy;

import java.util.UUID;

public class AccountNumberPolicy {
    public String generate() {
        return UUID.randomUUID().toString().substring(0, 10);
    }
}
