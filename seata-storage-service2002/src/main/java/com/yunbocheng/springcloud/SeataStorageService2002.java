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
public class SeataStorageService2002 {

    public static void main(String[] args) {
        SpringApplication.run(SeataStorageService2002.class, args);
    }

}
