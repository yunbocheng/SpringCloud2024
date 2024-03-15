package com.yunbocheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-03-12
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CloudAlibabaConsumerNacosOrder83 {

    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaConsumerNacosOrder83.class, args);
    }

}
