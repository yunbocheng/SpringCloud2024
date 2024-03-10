package com.yunbocheng.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-03-06
 */
@RestController
@RequestMapping("/pay")
public class PayCircuitController {

    //=========Resilience4j CircuitBreaker 的例子
    @GetMapping(value = "/circuit")
    public String myCircuit(@RequestParam("id") Integer id) {

        if(id == -4) throw new RuntimeException("----circuit id 不能负数");

        if(id == 9999) {
            try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
        }

        return "Hello, circuit! inputId:  "+id+" \t " + IdUtil.simpleUUID();
    }

    //=========Resilience4j bulkhead 的例子
//    @GetMapping(value = "/bulkhead/{id}")
//    public String myBulkhead(@PathVariable("id") Integer id)
//    {
//        if(id == -4) throw new RuntimeException("----bulkhead id 不能-4");
//
//        if(id == 9999)
//        {
//            try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
//        }
//
//        return "Hello, bulkhead! inputId:  "+id+" \t " + IdUtil.simpleUUID();
//    }
//
//
//    //=========Resilience4j ratelimit 的例子
//    @GetMapping(value = "/ratelimit/{id}")
//    public String myRatelimit(@PathVariable("id") Integer id)
//    {
//        return "Hello, myRatelimit欢迎到来 inputId:  "+id+" \t " + IdUtil.simpleUUID();
//    }

}
