package kz.shyngys.client_api.impl;

import kz.shyngys.client_api.dto.AccountCreateUpdateDto;
import kz.shyngys.client_api.dto.AccountReadDto;
import kz.shyngys.client_api.exception.not_found.NotFoundAccount;
import kz.shyngys.client_api.mapper.AccountCreateUpdateMapper;
import kz.shyngys.client_api.mapper.AccountReadMapper;
import kz.shyngys.client_api.model.db.Account;
import kz.shyngys.client_api.repository.AccountRepository;
import kz.shyngys.client_api.service.AccountLimitService;
import kz.shyngys.client_api.service.AccountService;
import kz.shyngys.client_api.validator.AccountValidator;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountValidator validator;
    private final AccountLimitService accountLimitService;

    @Override
    public AccountReadDto findById(@NonNull Long id) {
        return accountRepository.findById(id)
                .map(AccountReadMapper.INSTANCE::toDto)
                .orElseThrow(() -> new NotFoundAccount(id));
    }

    @Transactional
    @Override
    public Long create(@NonNull AccountCreateUpdateDto dto) {
        log.info("init create, start validation");

        validator.validate(dto);

        log.info("end validation, start mapping");

        Account account = AccountCreateUpdateMapper.INSTANCE.toAccount(dto);

        log.info("end mapping, start saving to db");

        Long accountId = accountRepository.save(account).getId();

        log.info("end saving to db, start creating default account limit");

        // to create default limit after creating of account
        accountLimitService.createDefault(accountId);

        log.info("end creating default account limit");

        return accountId;
    }

}

