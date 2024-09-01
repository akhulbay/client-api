package kz.shyngys.client_api.mapper;

import kz.shyngys.client_api.dto.AccountCreateUpdateDto;
import kz.shyngys.client_api.model.db.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

@Mapper
public interface AccountCreateUpdateMapper {

    AccountCreateUpdateMapper INSTANCE = Mappers.getMapper(AccountCreateUpdateMapper.class);

    @Mapping(target = "createdAt", qualifiedByName = "setDefaultCreatedDateTime")
    Account toAccount(AccountCreateUpdateDto dto);

    @Named("setDefaultCreatedDateTime")
    default LocalDateTime setDefaultCreatedDateTime(LocalDateTime dateTime) {
        return dateTime == null
                ? LocalDateTime.now()
                : dateTime;
    }

}
