package com.yunbocheng.springcloud.mapper;

import com.yunbocheng.springcloud.entities.Pay;
import com.yunbocheng.springcloud.entities.PayDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;


@Repository
public interface PayMapper extends Mapper<Pay> {
    Pay getPayById(@Param("id") Integer id);

    int updatePay(@Param("payDTO") PayDTO payDTO);

}