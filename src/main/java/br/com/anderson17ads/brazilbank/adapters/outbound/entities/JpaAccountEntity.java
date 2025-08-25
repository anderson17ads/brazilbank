package br.com.anderson17ads.brazilbank.adapters.outbound.entities;

import br.com.anderson17ads.brazilbank.domain.account.Account;
import br.com.anderson17ads.brazilbank.domain.account.AccountType;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "accounts")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JpaAccountEntity {
    @Id
    @GeneratedValue
    private UUID id;

    private String number;
    private BigDecimal balance;
    private UUID customerId;
    private AccountType type;

    public JpaAccountEntity(Account account) {
        this.id = account.getId();
        this.number = account.getNumber();
        this.balance = account.getBalance();
        this.customerId = account.getCustomerId();
        this.type = account.getType();
    }
}
