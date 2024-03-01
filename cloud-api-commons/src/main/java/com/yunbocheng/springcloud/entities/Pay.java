package com.yunbocheng.springcloud.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 表名：t_pay
 * 表注释：支付交易表
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_pay")
@Schema(title = "支付交易模型", description = "支付交易模型实体类")
public class Pay {

    /* 这个是persistence包中指定这个属性对应的是表中的ID字段  */
    @Id
    /* 这个注解一般喝 @Id 一起使用，声明主键ID的生成策略，这里使用 JDBC 的策略来生成主键 */
    @GeneratedValue(generator = "JDBC")
    @Schema(title = "主键", description = "存储支付流水的主键ID", format = "int64", example = "1")
    private Integer id;

    /**
     * 支付流水号
     */
    @Column(name = "pay_no")
    @Schema(title = "支付流水号", description = "存储支付流编号")
    private String payNo;

    /**
     * 订单流水号
     */
    @Column(name = "order_no")
    @Schema(title = "订单流水号", description = "存储订单流水编号")
    private String orderNo;

    /**
     * 用户账号ID
     */
    @Column(name = "user_id")
    @Schema(title = "用户账号ID", description = "存储用户账号ID")
    private Integer userId;

    /**
     * 交易金额
     */
    @Column(name = "amount")
    @Schema(title = "交易金额", description = "存储支付金额")
    private BigDecimal amount;

    /**
     * 删除标志，默认0不删除，1删除
     */
    @Column(name = "deleted")
    @Schema(title = "支付流水删除标注", description = "存储支付流水的删除标志")
    private Byte deleted;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @Schema(title = "创建时间", description = "存储支付流水的创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @Schema(title = "更新时间", description = "存储支付流水的更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

}