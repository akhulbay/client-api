package kz.shyngys.client_api.model.db;

import jakarta.persistence.*;
import kz.shyngys.client_api.model.Currency;
import kz.shyngys.client_api.model.ExpenseCategory;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    private Double sum;

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
