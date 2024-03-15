package com.yunbocheng.springcloud.service;

import com.yunbocheng.springcloud.entities.Account;

import java.math.BigDecimal;

public interface SeataAccountService {


    Account getAccountById(Long id);

    void decrease(Long userId, BigDecimal money);


}
