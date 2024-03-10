package com.yunbocheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-03-01
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudConsumerOrder80 {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrder80.class, args);
    }

}
