package br.com.anderson17ads.brazilbank.adapters.outbound.repositories.account;

import br.com.anderson17ads.brazilbank.adapters.outbound.entities.JpaAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaAccountRepository extends JpaRepository<JpaAccountEntity, UUID> {}
