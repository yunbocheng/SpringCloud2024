package com.yunbocheng.springcloud.mapper;

import com.yunbocheng.springcloud.entities.Storage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;

@Repository
public interface SeataStorageMapper extends Mapper<Storage> {


    Storage getStorageById(Long id);


    void decrease(@Param("productId") Long productId, @Param("count") Integer count);

}
