package com.yunbocheng.springcloud.service.impl;

import com.yunbocheng.springcloud.apis.AccountFeignApi;
import com.yunbocheng.springcloud.apis.StorageFeignApi;
import com.yunbocheng.springcloud.entities.Account;
import com.yunbocheng.springcloud.mapper.SeataAccountMapper;
import com.yunbocheng.springcloud.service.SeataAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-03-14
 */
@Service
@Slf4j
public class SeataAccountServiceImpl implements SeataAccountService {

    private final SeataAccountMapper seataAccountMapper;

    public SeataAccountServiceImpl(SeataAccountMapper seataAccountMapper) {
        this.seataAccountMapper = seataAccountMapper;
    }


    @Override
    public Account getAccountById(Long id) {
        return seataAccountMapper.getAccountById(id);
    }

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("-------- 开始扣减账户余额 ---------");
        seataAccountMapper.decrease(userId, money);

        myTimeOut();
        // int age = 10/0;
        log.info("-------- 扣减账户余额结束 ---------");
    }

    /*
    * 模拟超时异常，全局事务回滚
    * */
    private static void myTimeOut() {
        try {
            TimeUnit.SECONDS.sleep(65);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
