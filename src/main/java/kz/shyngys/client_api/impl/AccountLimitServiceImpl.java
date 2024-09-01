package kz.shyngys.client_api.impl;

import kz.shyngys.client_api.config.AccountLimitConfig;
import kz.shyngys.client_api.model.Currency;
import kz.shyngys.client_api.model.db.AccountLimit;
import kz.shyngys.client_api.repository.AccountLimitRepository;
import kz.shyngys.client_api.service.AccountLimitService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AccountLimitServiceImpl implements AccountLimitService {

    private final AccountLimitRepository accountLimitRepository;
    private final AccountLimitConfig config;

    @Transactional
    @Override
    public void createDefault(@NonNull Long accountId) {
        AccountLimit limit = AccountLimit.builder()
                .id(accountId)
                .sum(config.defaultLimitSum)
                .currencyShortName(Currency.valueOf(config.defaultCurrency))
                .dateTime(LocalDateTime.now())
                .build();

        accountLimitRepository.save(limit);
    }
}
