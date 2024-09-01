package kz.shyngys.client_api.mapper;

import kz.shyngys.client_api.dto.AccountReadDto;
import kz.shyngys.client_api.model.db.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountReadMapper {

    AccountReadMapper INSTANCE = Mappers.getMapper(AccountReadMapper.class);

    AccountReadDto toDto(Account account);

}
