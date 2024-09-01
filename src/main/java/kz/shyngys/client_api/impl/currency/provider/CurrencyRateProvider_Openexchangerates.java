package kz.shyngys.client_api.impl.currency.provider;

import kz.shyngys.client_api.model.CurrencyRateProviderType;
import kz.shyngys.client_api.service.CurrencyRateProvider;
import org.springframework.stereotype.Service;

@SuppressWarnings("SpellCheckingInspection")
@Service
public class CurrencyRateProvider_Openexchangerates implements CurrencyRateProvider {

    @Override
    public CurrencyRateProviderType getType() {
        return CurrencyRateProviderType.OPENEXCHANGERATES_ORG;
    }

    @Override
    public Object getRateToUsd() {
        return null;
    }

}
