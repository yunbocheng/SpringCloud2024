package com.yunbocheng.springcloud.controller;

import com.yunbocheng.springcloud.entities.PayDTO;
import com.yunbocheng.springcloud.entities.R;
import com.yunbocheng.springcloud.enums.ResultEnum;
import com.yunbocheng.springcloud.exception.AppException;
import com.yunbocheng.springcloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @auther chengyunbo
 * @create 2023-12-21 17:34
 */
@RestController
@Slf4j
/* @Tag注解：描述一个Controller模型的信息 */
@Tag(name = "支付微服务模块",description = "支付微服务控制器接口")
@RequestMapping("/pay")
public class PayController {

    private final PayService payService;

    public PayController(PayService payService) {
        this.payService = payService;
    }

    @GetMapping(value = "/getPayById")
    @Operation(summary = "按照ID查流水",description = "查询支付流水方法")
    public R getPayById(@RequestParam("id") Integer id) {
        if (id == -4) throw new AppException(ResultEnum.ARGS_VALID_ERROR);
        return R.ok().data("data", payService.getPayById(id));
    }

    @GetMapping(value = "/getPayAll")
    @Operation(summary = "查询全部流水",description = "查询全部流水方法")
    public R getPayAll() {
        return R.ok().data("data", payService.getPayAll());
    }

    @PostMapping(value = "/updatePay")
    @Operation(summary = "修改支付流水",description = "修改支付流水方法")
    public R updatePay(@RequestBody PayDTO payDTO) {
        return R.ok().data("data", payService.updatePay(payDTO));
    }

    @PostMapping(value = "/addPay")
    @Operation(summary = "新增支付流水",description = "新增支付流水方法")
    public R addPay(@RequestBody PayDTO payDTO) {
        return R.ok().data("data", payService.addPay(payDTO));
    }


    @GetMapping(value = "/delPayById")
    @Operation(summary = "删除支付流水",description = "删除支付流水方法")
    public R delPayById(@RequestParam("id") Integer id) {
        return R.ok().data("data", payService.delPayById(id));
    }

    @Value(value = "${server.port}")
    private String port;

    @Value(value = "${chengyunbo.info}")
    private String info;

    @GetMapping(value = "/getInfo")
    public void getInfo() {
        System.out.println(port);
        System.out.println(info);
    }

}
