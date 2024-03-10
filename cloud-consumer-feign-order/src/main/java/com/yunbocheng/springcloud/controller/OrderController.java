package com.yunbocheng.springcloud.controller;

import com.yunbocheng.springcloud.apis.PayFeignApi;
import com.yunbocheng.springcloud.entities.PayDTO;
import com.yunbocheng.springcloud.entities.R;
import org.springframework.web.bind.annotation.*;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-03-01
 */
@RestController
@RequestMapping("/feign")
public class OrderController {

    private final PayFeignApi payFeignApi;

    public OrderController(PayFeignApi payFeignApi) {
        this.payFeignApi = payFeignApi;
    }

    @GetMapping("/getPayById")
    public R getPayById(@RequestParam("id") Integer id) {
        return payFeignApi.getPayById(id);
    }

    @PostMapping(value = "/addPay")
    public R addPay(@RequestBody PayDTO payDTO) {
        return payFeignApi.addPay(payDTO);
    }

    @GetMapping(value = "/getInfo")
    public void getInfo() {
        payFeignApi.getInfo();
    }
}
