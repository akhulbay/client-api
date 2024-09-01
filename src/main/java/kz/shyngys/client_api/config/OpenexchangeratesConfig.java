package kz.shyngys.client_api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OpenexchangeratesConfig {

    @Value("${currency.rate.provider.openexchangerates.usefake}")
    public Boolean useFake;

    @Value("${currency.rate.provider.openexchangerates.apikey}")
    public String apiKey;

    @Value("${currency.rate.provider.openexchangerates.url}")
    public String url;

}
