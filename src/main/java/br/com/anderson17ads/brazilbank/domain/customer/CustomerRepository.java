package br.com.anderson17ads.brazilbank.domain.customer;

import java.util.List;
import java.util.UUID;

public interface CustomerRepository {
    Customer save(Customer customer);
    Customer findById(UUID id);
    List<Customer> findAll();
    void deleteById(UUID id);
}
