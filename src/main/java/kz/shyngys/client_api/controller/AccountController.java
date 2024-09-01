package kz.shyngys.client_api.controller;

import kz.shyngys.client_api.dto.AccountCreateUpdateDto;
import kz.shyngys.client_api.dto.AccountReadDto;
import kz.shyngys.client_api.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/{id}")
    public AccountReadDto findById(@PathVariable Long id) {
        return accountService.findById(id);
    }

    @PostMapping
    public Long create(@RequestBody AccountCreateUpdateDto dto) {
        return accountService.create(dto);
    }

}
