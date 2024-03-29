package com.yunbocheng.springcloud.apis;

import com.yunbocheng.springcloud.entities.PayDTO;
import com.yunbocheng.springcloud.entities.R;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

//@FeignClient(value = "cloud-provider-payment")
@FeignClient(value = "cloud-gateway")
public interface PayFeignApi {

    @GetMapping(value = "/pay/getPayById")
    public R getPayById(@RequestParam("id") Integer id);

    @PostMapping(value = "/pay/addPay")
    public R addPay(@RequestBody PayDTO payDTO);

    /*
    * 这个接口测试 feign 自带负载均衡
    * */
    @GetMapping(value = "/pay/getInfo")
    public void getInfo();

    @GetMapping(value = "/pay/circuit")
    public String myCircuit(@RequestParam("id") Integer id);


    @GetMapping(value = "/pay/micrometer/{id}")
    public String myMicrometer(@PathVariable("id") Integer id);

    @GetMapping(value = "/pay/gateway/get/{id}")
    public R getGateWayById(@PathVariable("id") Integer id);

    @GetMapping(value = "/pay/gateway/info")
    public R getGateWayInfo();

    @GetMapping(value = "/pay/gateway/filter")
    public R getGatewayFilter(HttpServletRequest request);
}
