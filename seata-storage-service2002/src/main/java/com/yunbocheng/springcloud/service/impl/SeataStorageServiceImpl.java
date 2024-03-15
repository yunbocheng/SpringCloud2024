package com.yunbocheng.springcloud.service.impl;


import com.yunbocheng.springcloud.entities.Storage;
import com.yunbocheng.springcloud.mapper.SeataStorageMapper;
import com.yunbocheng.springcloud.service.SeataStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-03-14
 */

@Service
@Slf4j
public class SeataStorageServiceImpl implements SeataStorageService {

    private final SeataStorageMapper seataStorageMapper;

    public SeataStorageServiceImpl(SeataStorageMapper seataStorageMapper) {
        this.seataStorageMapper = seataStorageMapper;
    }

    @Override
    public Storage getStorageById(Long id) {
        return seataStorageMapper.getStorageById(id);
    }

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("--------- storage-service中扣减库存开始");
        seataStorageMapper.decrease(productId, count);
        log.info("--------- storage-service中扣减库存结束");
    }


}
