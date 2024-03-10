package com.yunbocheng.springcloud.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-03-06
 */
@Configuration
public class FeignConfig {

    /*
    * 配置 openFeign 的重试策略
    * */
    @Bean
    public Retryer retryer() {
        return  Retryer.NEVER_RETRY;  //Feign默认配置是不走重试策略的

        // 最大请求次数为3=1(default) + 2(重试)，初始间隔时间为100ms，重试最大间隔时间为1s
        // return new Retryer.Default(100,1,3);
    }


    /*
    * 配置 openFeign 的日志配置
    * */
    @Bean
    Logger.Level feignLoggerLevel() {
        /*
        * 开启日志的最高级别
        * */
        return Logger.Level.FULL;
    }
}
