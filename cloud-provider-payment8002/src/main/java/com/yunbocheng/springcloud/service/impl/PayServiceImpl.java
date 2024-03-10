package com.yunbocheng.springcloud.service.impl;

import com.yunbocheng.springcloud.entities.Pay;
import com.yunbocheng.springcloud.entities.PayDTO;
import com.yunbocheng.springcloud.mapper.PayMapper;
import com.yunbocheng.springcloud.service.PayService;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Boolean updatePay(PayDTO payDTO) {
        return payMapper.updatePay(payDTO) > 0;
    }

    @Override
    public Boolean addPay(PayDTO payDTO) {
        return payMapper.addPay(payDTO) > 0;
    }

    @Override
    public Boolean delPayById(Integer id) {
        return payMapper.delPayById(id) > 0;
    }

    @Override
    public List<Pay> getPayAll() {
        return payMapper.getPayAll();
    }

}
