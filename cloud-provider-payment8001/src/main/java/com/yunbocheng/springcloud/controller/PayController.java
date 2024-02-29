package com.yunbocheng.springcloud.controller;

import com.yunbocheng.springcloud.resp.R;
import com.yunbocheng.springcloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther chengyunbo
 * @create 2023-12-21 17:34
 */
@RestController
@Slf4j
@Tag(name = "支付微服务模块",description = "支付CRUD")
@RequestMapping("/pay")
public class PayController
{
    @Resource
    private PayService payService;

    @GetMapping(value = "/getPayById")
    @Operation(summary = "按照ID查流水",description = "查询支付流水方法")
    public R getById(@Param("id") Integer id)
    {
        if(id == -4) throw new RuntimeException("id不能为负数");

        return R.ok().data("data", payService.getById(id));
    }



}
