package kz.shyngys.client_api.model.db;

import jakarta.persistence.*;
import kz.shyngys.client_api.model.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "t_account_limit")
public class AccountLimit {

    @Id
    private Long id;

    private Double sum;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "currency_short_name")
    @Enumerated(EnumType.STRING)
    private Currency currencyShortName;

}
