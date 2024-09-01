package kz.shyngys.client_api.controller;

import kz.shyngys.client_api.service.AccountLimitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account-limit")
public class AccountLimitController {

    private final AccountLimitService accountLimitService;

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id,
                       @RequestParam("limit") Double limit) {
        accountLimitService.update(id, limit);
    }

}
