package com.yunbocheng.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-03-14
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.yunbocheng.springcloud.mapper"})
@EnableDiscoveryClient
public class SeataOrderService2001 {

    public static void main(String[] args) {
        SpringApplication.run(SeataOrderService2001.class, args);
    }

}
