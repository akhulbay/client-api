package kz.shyngys.client_api.config;

import jakarta.annotation.PostConstruct;
import kz.shyngys.client_api.model.Currency;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AccountLimitConfig {

    @Value("${account.default.limit.sum}")
    public Double defaultLimitSum;

    @Value("${account.default.limit.currency}")
    public String defaultCurrency;

    /**
     * Method is used to apply Fail Fast, so if default currency is wrong app will not start
     */
    @PostConstruct
    private void init() {
        try {
            Currency.valueOf(defaultCurrency);
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage());
            throw new RuntimeException("Invalid currency: " + defaultCurrency);
        }
    }

}
