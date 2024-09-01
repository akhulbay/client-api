package kz.shyngys.client_api.service;

import kz.shyngys.client_api.model.CurrencyRateProviderType;

public interface CurrencyRateProvider {

    CurrencyRateProviderType getType();

    Object getRateToUsd();

}
