package br.com.anderson17ads.brazilbank.adapters.outbound.repositories;

import br.com.anderson17ads.brazilbank.adapters.outbound.entities.JpaAccountEntity;
import br.com.anderson17ads.brazilbank.domain.account.Account;
import br.com.anderson17ads.brazilbank.domain.account.AccountRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class AccountRepositoryImpl implements AccountRepository {
    private final JpaAccountRepository jpaAccountRepository;

    public AccountRepositoryImpl(JpaAccountRepository jpaAccountRepository) {
        this.jpaAccountRepository = jpaAccountRepository;
    }

    @Override
    public Account save(Account account) {
        JpaAccountEntity entity = new JpaAccountEntity(account);
        this.jpaAccountRepository.save(entity);
        return new Account(
            entity.getId(),
            entity.getNumber(),
            entity.getBalance(),
            entity.getCustomerId(),
            entity.getType()
        );
    }

    @Override
    public Account findById(UUID id) {
        Optional<JpaAccountEntity> jpaAccountEntity = this.jpaAccountRepository.findById(id);
        return jpaAccountEntity.map(entity -> new Account(
            entity.getId(),
            entity.getNumber(),
            entity.getBalance(),
            entity.getCustomerId(),
            entity.getType()
        )).orElse(null);
    }

    @Override
    public List<Account> findAll() {
        return this.jpaAccountRepository
            .findAll()
            .stream()
            .map(entity -> new Account(
                entity.getId(),
                entity.getNumber(),
                entity.getBalance(),
                entity.getCustomerId(),
                entity.getType()
            ))
            .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        this.jpaAccountRepository.deleteById(id);
    }
}
