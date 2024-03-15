package com.yunbocheng.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-02-29
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.yunbocheng.springcloud.mapper"})
@EnableDiscoveryClient
@RefreshScope
public class CloudProviderPayment8001 {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment8001.class, args);
    }

}