package com.yunbocheng.springcloud.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-03-12
 */
@RestController
@RefreshScope //在控制器类加入@RefreshScope注解使当前类下的配置支持Nacos的动态刷新功能
public class NacosConfigClientController {



}
