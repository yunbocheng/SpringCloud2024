package com.yunbocheng.springcloud.mapper;

import com.yunbocheng.springcloud.entities.Order;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface SeataOrderMapper extends Mapper<Order> {


    Order getOrderById(@Param("id") Long id);

    Long addOrder(@Param("order") Order order);


    void updateOrderStatusById(@Param("orderFromDB") Order orderFromDB);


}
