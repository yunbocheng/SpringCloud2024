package com.yunbocheng.springcloud.service;

import com.yunbocheng.springcloud.entities.Storage;

import java.math.BigDecimal;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-03-14
 */
public interface SeataStorageService {


    Storage getStorageById(Long id);

    void decrease(Long productId, Integer count);

}
