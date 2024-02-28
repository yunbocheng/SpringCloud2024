package com.yunbocheng.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author : YunboCheng
 * @date : 1:12 2024/2/29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pay {

    private Integer id;

    private String payNo;

    private String orderNo;

    private Integer userId;

    private BigDecimal amount;

    private Byte deleted;

    private Date createTime;

    private Date updateTime;

}
