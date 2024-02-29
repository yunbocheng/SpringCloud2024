package com.yunbocheng.springcloud.mapper;

import com.yunbocheng.springcloud.entities.Pay;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;


@Repository
public interface PayMapper extends Mapper<Pay> {
    Pay getById(@Param("id") Integer id);

}