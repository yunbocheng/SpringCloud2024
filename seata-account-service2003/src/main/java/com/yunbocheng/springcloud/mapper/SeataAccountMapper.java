package com.yunbocheng.springcloud.mapper;


import com.yunbocheng.springcloud.entities.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;

@Repository
public interface SeataAccountMapper extends Mapper<Account> {

    Account getAccountById(@Param("id") Long id);

    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);


}
