package com.yunbocheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-03-01
 */
@SpringBootApplication
@EnableDiscoveryClient // 该注解用于向使用consul为注册中心时注册服务
@EnableFeignClients // 启动feign客户端，定义服务+绑定接口，以生命是的方法优雅而简单的是心啊服务调用
public class CloudConsumerFeignOrder80 {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerFeignOrder80.class, args);
    }

}
