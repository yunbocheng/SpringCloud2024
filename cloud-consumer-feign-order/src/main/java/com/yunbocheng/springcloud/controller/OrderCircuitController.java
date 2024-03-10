package com.yunbocheng.springcloud.controller;

import com.yunbocheng.springcloud.apis.PayFeignApi;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.*;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-03-06
 */
@RestController
@RequestMapping("/feign")
public class OrderCircuitController {

    private final PayFeignApi payFeignApi;

    public OrderCircuitController(PayFeignApi payFeignApi) {
        this.payFeignApi = payFeignApi;
    }


    @GetMapping(value = "/circuit")
    @CircuitBreaker(name = "cloud-payment-service", fallbackMethod = "myCircuitFallback")
    public String myCircuitBreaker(@RequestParam("id") Integer id) {
        return payFeignApi.myCircuit(id);
    }

    //myCircuitFallback就是服务降级后的兜底处理方法
    public String myCircuitFallback(Exception e) {
        // 这里是容错处理逻辑，返回备用结果
        return "myCircuitFallback，系统繁忙，请稍后再试-----/(ㄒoㄒ)/~~";
    }

}
