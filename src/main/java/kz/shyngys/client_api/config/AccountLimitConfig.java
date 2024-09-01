package kz.shyngys.client_api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AccountLimitConfig {

    @Value("${account.default.limit.sum}")
    public Double defaultLimitSum;

    @Value("${account.default.limit.currency}")
    public String defaultCurrency;

}
