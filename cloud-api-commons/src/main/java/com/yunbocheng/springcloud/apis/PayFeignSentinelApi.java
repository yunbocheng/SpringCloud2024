package com.yunbocheng.springcloud.apis;

import com.yunbocheng.springcloud.entities.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-provider-payment", fallback = PayFeignSentinelApiFallback.class)
public interface PayFeignSentinelApi {

    @GetMapping(value = "/pay/nacos/get/{orderNo}")
    public R getPayByOrderNo(@PathVariable("orderNo") String orderNo);

}
