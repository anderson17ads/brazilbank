package br.com.anderson17ads.brazilbank.domain.account;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountRepository {
    Account save(Account account);
    Account findById(UUID id);
    List<Account> findAll();
    void deleteById(UUID id);
}
