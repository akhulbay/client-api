package kz.shyngys.client_api.service;

import kz.shyngys.client_api.dto.AccountCreateUpdateDto;

public interface AccountService {

    Long create(AccountCreateUpdateDto dto);

}
