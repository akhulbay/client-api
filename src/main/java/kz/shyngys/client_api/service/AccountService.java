package kz.shyngys.client_api.service;

import kz.shyngys.client_api.dto.AccountCreateUpdateDto;
import kz.shyngys.client_api.dto.AccountReadDto;

public interface AccountService {

    AccountReadDto findById(Long id);

    Long create(AccountCreateUpdateDto dto);

}
