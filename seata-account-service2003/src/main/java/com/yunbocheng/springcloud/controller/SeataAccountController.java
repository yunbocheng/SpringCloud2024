package com.yunbocheng.springcloud.controller;

import com.yunbocheng.springcloud.entities.R;
import com.yunbocheng.springcloud.service.SeataAccountService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-03-14
 */
@RestController
@RequestMapping("/account")
public class SeataAccountController {

    private final SeataAccountService seataAccountService;

    public SeataAccountController(SeataAccountService seataAccountService) {
        this.seataAccountService = seataAccountService;
    }

    @GetMapping(value = "/getAccountById/{id}")
    public R getAccountById(@PathVariable("id") Long id) {
        return R.ok().data("data", seataAccountService.getAccountById(id));
    }

    @PostMapping(value = "/decrease")
    void decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        seataAccountService.decrease(userId, money);
    }

}
