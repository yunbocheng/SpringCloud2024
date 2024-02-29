package com.yunbocheng.springcloud.service.impl;

import com.yunbocheng.springcloud.entities.Pay;
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
    @Resource
    private PayMapper payMapper;

    @Override
    public Pay getById(Integer id)
    {
        return payMapper.getById(id);
    }

}
