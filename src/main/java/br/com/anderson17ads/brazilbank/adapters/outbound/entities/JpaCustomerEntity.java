package br.com.anderson17ads.brazilbank.adapters.outbound.entities;

import br.com.anderson17ads.brazilbank.domain.customer.Customer;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "customers")
@Setter
@Getter
@NoArgsConstructor
public class JpaCustomerEntity {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String email;
    private String document;
    private String phone;
    private LocalDate birthDate;

    public JpaCustomerEntity(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.email = customer.getEmail();
        this.document = customer.getDocument();
        this.phone = customer.getPhone();
        this.birthDate = customer.getBirthDate();
    }
}
