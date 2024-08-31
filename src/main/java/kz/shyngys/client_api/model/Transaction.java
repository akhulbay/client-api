package kz.shyngys.client_api.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@EqualsAndHashCode(exclude = {"accountFrom", "accountTo"})
@ToString(exclude = {"accountFrom", "accountTo"})
@Getter
@Setter
@Entity
@Table(name = "t_transaction")
public class Transaction {

    @Id
    private Long id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    private Long sum;

    @Column(name = "currency_short_name")
    @Enumerated(EnumType.STRING)
    private Currency currencyShortName;

    @Column(name = "category")
    private ExpenseCategory category;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account accountFrom;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account accountTo;

}
