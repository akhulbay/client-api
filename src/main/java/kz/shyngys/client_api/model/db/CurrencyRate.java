package kz.shyngys.client_api.model.db;

import jakarta.persistence.*;
import kz.shyngys.client_api.model.Currency;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_currency_rate")
public class CurrencyRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "currency_short_name")
    @Enumerated(EnumType.STRING)
    private Currency currencyShortName;

    @Column(name = "rate_to_usd")
    private Double rateToUsd;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

}
