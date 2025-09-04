package br.com.anderson17ads.brazilbank.adapters.outbound.repositories.customer;

import br.com.anderson17ads.brazilbank.adapters.outbound.entities.JpaCustomerEntity;
import br.com.anderson17ads.brazilbank.domain.customer.Customer;
import br.com.anderson17ads.brazilbank.domain.customer.CustomerRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class JpaCustomerRepositoryAdapter implements CustomerRepository {
    private final JpaCustomerRepository jpaCustomerRepository;

    public JpaCustomerRepositoryAdapter(JpaCustomerRepository jpaCustomerRepository) {
        this.jpaCustomerRepository = jpaCustomerRepository;
    }

    @Override
    public Customer save(Customer customer) {
        JpaCustomerEntity jpaCustomerEntity = new JpaCustomerEntity(customer);
        jpaCustomerRepository.save(jpaCustomerEntity);
        return new Customer(
                jpaCustomerEntity.getId(),
                jpaCustomerEntity.getName(),
                jpaCustomerEntity.getEmail(),
                jpaCustomerEntity.getDocument(),
                jpaCustomerEntity.getDocument(),
                jpaCustomerEntity.getBirthDate()
        );
    }

    @Override
    public Customer findById(UUID id) {
        Optional<JpaCustomerEntity> jpaCustomerEntity = jpaCustomerRepository.findById(id);
        return jpaCustomerEntity.map(entity -> new Customer(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getDocument(),
                entity.getDocument(),
                entity.getBirthDate()
        )).orElse(null);
    }

    @Override
    public List<Customer> findAll() {
        return jpaCustomerRepository
                .findAll()
                .stream()
                .map(entity -> new Customer(
                        entity.getId(),
                        entity.getName(),
                        entity.getEmail(),
                        entity.getDocument(),
                        entity.getDocument(),
                        entity.getBirthDate()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        jpaCustomerRepository.deleteById(id);
    }
}
