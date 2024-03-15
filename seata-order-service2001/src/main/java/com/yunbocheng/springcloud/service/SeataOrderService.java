package com.yunbocheng.springcloud.service;

import com.yunbocheng.springcloud.entities.Order;

public interface SeataOrderService {


    Order getOrderById(Long id);

    void addOrder(Order order);

}
