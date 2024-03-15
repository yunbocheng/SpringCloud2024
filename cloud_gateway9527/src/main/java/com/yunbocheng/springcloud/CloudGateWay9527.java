package com.yunbocheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-03-10
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudGateWay9527 {
    public static void main(String[] args) {
        SpringApplication.run(CloudGateWay9527.class, args);
    }
}
