package br.com.anderson17ads.brazilbank.adapters.outbound.mapper;

import br.com.anderson17ads.brazilbank.adapters.outbound.entities.JpaCustomerEntity;
import br.com.anderson17ads.brazilbank.domain.customer.Customer;

public class CustomerMapper {
    public static Customer toDomain(JpaCustomerEntity entity) {
        return new Customer(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getDocument(),
                entity.getPhone(),
                entity.getBirthDate()
        );
    }
}
