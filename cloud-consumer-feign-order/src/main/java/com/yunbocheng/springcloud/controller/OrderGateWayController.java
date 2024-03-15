package com.yunbocheng.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.yunbocheng.springcloud.apis.PayFeignApi;
import com.yunbocheng.springcloud.entities.R;
import com.yunbocheng.springcloud.enums.ResultEnum;
import com.yunbocheng.springcloud.exception.AppException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-03-11
 */
@RestController
@RequestMapping("/feign")
public class OrderGateWayController {

    private final PayFeignApi payFeignApi;

    public OrderGateWayController(PayFeignApi payFeignApi) {
        this.payFeignApi = payFeignApi;
    }

    @GetMapping(value = "/gateway/get/{id}")
    public R getPayById(@PathVariable("id") Integer id) {
        if (id == -4) throw new AppException(ResultEnum.ARGS_VALID_ERROR);
        return R.ok().data("data", payFeignApi.getGateWayById(id));
    }

    @GetMapping(value = "/gateway/info")
    public R getGateWayInfo() {
        return  R.ok().data("data", "gateway info test:" + IdUtil.simpleUUID());
    }

    @GetMapping(value = "/gateway/filter")
    public R getGatewayFilter(HttpServletRequest request){
        return R.ok().data("data", payFeignApi.getGatewayFilter(request));
    }

}
