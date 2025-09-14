package br.com.anderson17ads.brazilbank.adapters.outbound.repositories.account;

import br.com.anderson17ads.brazilbank.adapters.outbound.entities.JpaAccountEntity;
import br.com.anderson17ads.brazilbank.adapters.outbound.mapper.AccountMapper;
import br.com.anderson17ads.brazilbank.domain.account.Account;
import br.com.anderson17ads.brazilbank.domain.account.AccountRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class JpaAccountRepositoryAdapter implements AccountRepository {
    private final JpaAccountRepository jpaAccountRepository;

    public JpaAccountRepositoryAdapter(JpaAccountRepository jpaAccountRepository) {
        this.jpaAccountRepository = jpaAccountRepository;
    }

    @Override
    public Account save(Account account) {
        JpaAccountEntity entity = new JpaAccountEntity(account);
        jpaAccountRepository.save(entity);
        return AccountMapper.toEntity(entity);
    }

    @Override
    public Account findById(UUID id) {
        Optional<JpaAccountEntity> jpaAccountEntity = jpaAccountRepository.findById(id);
        return jpaAccountEntity.map(AccountMapper::toEntity).orElse(null);
    }

    @Override
    public List<Account> findAll() {
        return jpaAccountRepository
                .findAll()
                .stream()
                .map(AccountMapper::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        jpaAccountRepository.deleteById(id);
    }

    @Override
    public long countByCustomerId(UUID customerId) {
        return jpaAccountRepository.countByCustomerId(customerId);
    }
}
