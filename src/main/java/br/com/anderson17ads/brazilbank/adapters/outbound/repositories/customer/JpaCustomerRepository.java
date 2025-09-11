package br.com.anderson17ads.brazilbank.adapters.outbound.repositories.customer;

import br.com.anderson17ads.brazilbank.adapters.outbound.entities.JpaCustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaCustomerRepository extends JpaRepository<JpaCustomerEntity, UUID> {
    Optional<JpaCustomerEntity> findByEmail(String email);
    boolean existsByEmail(String email);
}