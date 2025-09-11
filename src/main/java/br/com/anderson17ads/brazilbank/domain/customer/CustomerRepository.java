package br.com.anderson17ads.brazilbank.domain.customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
    Customer save(Customer customer);
    Optional<Customer> findById(UUID id);
    Optional<Customer> findByEmail(String email);
    boolean existsById(UUID id);
    boolean existsByEmail(String email);
    List<Customer> findAll();
    void deleteById(UUID id);
}
