package br.com.anderson17ads.brazilbank.adapters.outbound.mapper;

import br.com.anderson17ads.brazilbank.adapters.outbound.entities.JpaAccountEntity;
import br.com.anderson17ads.brazilbank.domain.account.Account;

public class AccountMapper {
    public static Account toEntity(JpaAccountEntity entity) {
        return new Account(
                entity.getId(),
                entity.getNumber(),
                entity.getBalance(),
                entity.getCustomerId(),
                entity.getType()
        );
    }
}
