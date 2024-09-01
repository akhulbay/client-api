package kz.shyngys.client_api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AccountReadDto {

    private Long id;

    private LocalDateTime createdAt;

}
