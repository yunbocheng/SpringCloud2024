package com.yunbocheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import javax.swing.*;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-03-12
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaConfigNacosClient3377 {

    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaConfigNacosClient3377.class, args);
    }

}
