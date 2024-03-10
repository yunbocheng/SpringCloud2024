package com.yunbocheng.springcloud.controller;

import com.yunbocheng.springcloud.entities.PayDTO;
import com.yunbocheng.springcloud.entities.R;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-03-01
 */
@RestController
@RequestMapping("/consumer")
@Tag(name= "消费业务模块", description = "消费微服务控制器接口")
public class OrderController {

    //private static final String PAY_URL = "http://localhost:8001";

    private static final String PAY_URL = "http://cloud-provider-payment";


    private final RestTemplate restTemplate;

    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/getPayById")
    public R getPayById(@RequestParam("id") Integer id) {
        // 这里注意需要将url拼接为 id={id} ，需要加上这个传递的参数
        return restTemplate.getForObject(PAY_URL + "/pay/getPayById?id={id}", R.class, id);
    }

    @PostMapping("/addPay")
    public R addPay(@RequestBody PayDTO payDTO) {
        return restTemplate.postForObject(PAY_URL + "/pay/addPay", payDTO, R.class);
    }

    @GetMapping("/getPayAll")
    public R getPayAll() {
        return restTemplate.getForObject(PAY_URL + "/pay/getPayAll", R.class);
    }

    @PostMapping("/updatePay")
    public R updatePay(@RequestBody PayDTO payDTO) {
        return restTemplate.postForObject(PAY_URL + "/pay/updatePay", payDTO, R.class);
    }

    @GetMapping("/delPayById")
    public R delPayById(@RequestParam("id") Integer id) {
        return restTemplate.getForObject(PAY_URL + "/pay/delPayById?id={id}", R.class, id);
    }

    @GetMapping("/getInfo")
    public void getInfo(@RequestParam("id") Integer id) {
        restTemplate.getForObject(PAY_URL + "/pay/getInfo", R.class);
    }
}
