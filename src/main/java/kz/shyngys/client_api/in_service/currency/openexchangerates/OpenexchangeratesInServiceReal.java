package kz.shyngys.client_api.in_service.currency.openexchangerates;

import kz.shyngys.client_api.config.OpenexchangeratesConfig;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;

@RequiredArgsConstructor
public class OpenexchangeratesInServiceReal implements OpenexchangeratesInService {

    private final OpenexchangeratesConfig config;
    private final OkHttpClient okHttpClient;

    @Override
    public Object getCurrenciesRateToUsd() {
        return null;
    }

}
