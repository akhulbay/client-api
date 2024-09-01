package kz.shyngys.client_api.impl;

import kz.shyngys.client_api.dto.AccountCreateUpdateDto;
import kz.shyngys.client_api.mapper.AccountCreateUpdateMapper;
import kz.shyngys.client_api.model.db.Account;
import kz.shyngys.client_api.repository.AccountRepository;
import kz.shyngys.client_api.service.AccountService;
import kz.shyngys.client_api.validator.AccountValidator;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountValidator validator;

    @Transactional
    @Override
    public Long create(@NonNull AccountCreateUpdateDto dto) {
        validator.validate(dto);

        Account account = AccountCreateUpdateMapper.INSTANCE.toAccount(dto);

        return accountRepository.save(account).getId();
    }

}
