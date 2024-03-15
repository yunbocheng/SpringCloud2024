package com.yunbocheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-03-12
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaProviderPayment9001 {

    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaProviderPayment9001.class, args);
    }
}
