package kz.shyngys.client_api.factory;

import kz.shyngys.client_api.config.OpenexchangeratesConfig;
import kz.shyngys.client_api.in_service.currency.openexchangerates.OpenexchangeratesInServiceFake;
import kz.shyngys.client_api.in_service.currency.openexchangerates.OpenexchangeratesInServiceReal;
import kz.shyngys.client_api.in_service.currency.openexchangerates.OpenexchangeratesInService;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CurrencyRateInServiceFactory {

    private final OpenexchangeratesConfig openexchangeratesConfig;
    private final OkHttpClient okHttpClient;

    @Bean
    public OpenexchangeratesInService openexchangeratesInService() {
        return openexchangeratesConfig.useFake
                ? new OpenexchangeratesInServiceFake()
                : new OpenexchangeratesInServiceReal(openexchangeratesConfig, okHttpClient);
    }

}
