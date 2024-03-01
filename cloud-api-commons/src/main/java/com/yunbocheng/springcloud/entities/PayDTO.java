package com.yunbocheng.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-02-29
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PayDTO {


    private Integer id;

    private String payNo;

    private String orderNo;

    private Integer userId;

    private BigDecimal amount;

    private Byte deleted;
}
