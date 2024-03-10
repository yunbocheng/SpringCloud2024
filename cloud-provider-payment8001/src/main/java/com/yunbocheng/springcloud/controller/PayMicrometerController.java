package com.yunbocheng.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import org.springframework.web.bind.annotation.*;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-03-08
 */
@RestController
@RequestMapping("/pay")
public class PayMicrometerController
{
    /**
     * Micrometer(Sleuth)进行链路监控的例子
     * @param id
     * @return
     */
    @GetMapping(value = "/micrometer/{id}")
    public String myMicrometer(@PathVariable("id") Integer id) {
        return "Hello, 欢迎到来myMicrometer inputId:  "+id+" \t    服务返回:" + IdUtil.simpleUUID();
    }
}