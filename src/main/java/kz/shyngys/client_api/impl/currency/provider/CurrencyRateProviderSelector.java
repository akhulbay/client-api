package kz.shyngys.client_api.impl.currency.provider;

import jakarta.annotation.PostConstruct;
import kz.shyngys.client_api.model.CurrencyRateProviderType;
import kz.shyngys.client_api.service.CurrencyRateProvider;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class CurrencyRateProviderSelector {

    private final List<CurrencyRateProvider> currencyRateProviders;

    private final Map<CurrencyRateProviderType, CurrencyRateProvider> currencyRateProviderMap = new HashMap<>();

    @PostConstruct
    private void init() {
        for (CurrencyRateProvider provider : currencyRateProviders) {
            if (currencyRateProviderMap.containsKey(provider.getType())) {
                throw new RuntimeException("Currency rate provider " + provider.getType() + " already exists");
            }

            currencyRateProviderMap.put(provider.getType(), provider);
        }
    }

    @NonNull
    public CurrencyRateProvider get(CurrencyRateProviderType type) {
        if (!currencyRateProviderMap.containsKey(type)) {
            throw new RuntimeException("Currency rate provider " + type + " does not exist");
        }

        return currencyRateProviderMap.get(type);
    }

}
