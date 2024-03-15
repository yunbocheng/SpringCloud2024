package com.yunbocheng.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-03-14
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.yunbocheng.springcloud.mapper"})
@EnableDiscoveryClient
@EnableFeignClients
public class SeataAccountService2003 {

    public static void main(String[] args) {
        SpringApplication.run(SeataAccountService2003.class, args);
    }

}
