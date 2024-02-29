package com.yunbocheng.springcloud.service.impl;

import com.yunbocheng.springcloud.entities.Pay;
import com.yunbocheng.springcloud.entities.PayDTO;
import com.yunbocheng.springcloud.mapper.PayMapper;
import com.yunbocheng.springcloud.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @auther chengyunbo
 * @create 2023-12-21 17:30
 */
@Service
public class PayServiceImpl implements PayService {

    private final PayMapper payMapper;

    public PayServiceImpl(PayMapper payMapper) {
        this.payMapper = payMapper;
    }

    @Override
    public Pay getPayById(Integer id) {
        return payMapper.getPayById(id);
    }

    @Override
    public boolean updatePay(PayDTO payDTO) {
        return payMapper.updatePay(payDTO) > 0;
    }

}
