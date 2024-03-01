package com.yunbocheng.springcloud.service;

import com.yunbocheng.springcloud.entities.Pay;
import com.yunbocheng.springcloud.entities.PayDTO;

import java.util.List;

/**
 * @auther chengyunbo
 * @create 2023-12-21 17:28
 */
public interface PayService {

    Pay getPayById(Integer id);

    Boolean updatePay(PayDTO payDTO);

    Boolean addPay(PayDTO payDTO);

    Boolean delPayById(Integer id);

    List<Pay> getPayAll();
}
