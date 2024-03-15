package com.yunbocheng.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-03-13
 */
@RestController
@Slf4j
public class EmpowerController {


    @GetMapping(value = "/empower")
    public String requestSentinel() {
      log.info("测试 Sentinel 授权规则empower");
      return "Sentinel授权规则";
    }

}
