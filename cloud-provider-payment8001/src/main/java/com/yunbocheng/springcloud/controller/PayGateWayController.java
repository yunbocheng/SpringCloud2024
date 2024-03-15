package com.yunbocheng.springcloud.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.yunbocheng.springcloud.entities.R;
import com.yunbocheng.springcloud.enums.ResultEnum;
import com.yunbocheng.springcloud.exception.AppException;
import com.yunbocheng.springcloud.service.PayService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-03-10
 */
@RestController
@RequestMapping("/pay")
public class PayGateWayController {

    private final PayService payService;

    public PayGateWayController(PayService payService) {
        this.payService = payService;
    }

    @GetMapping(value = "/gateway/get/{id}")
    public R getGateWayById(@PathVariable("id") Integer id) {
        if (id == -4) throw new AppException(ResultEnum.ARGS_VALID_ERROR);
        return R.ok().data("data", payService.getPayById(id));
    }

    @GetMapping(value = "/gateway/info")
    public R getGateWayInfo() {
        return  R.ok().data("data", "gateway info test:" + IdUtil.simpleUUID());
    }

    @GetMapping(value = "/gateway/filter")
    public R getGatewayFilter(HttpServletRequest request)
    {
        String result = "";
        Enumeration<String> headers = request.getHeaderNames();
        while(headers.hasMoreElements())
        {
            String headName = headers.nextElement();
            String headValue = request.getHeader(headName);
            System.out.println("请求头名: " + headName +"\t\t\t"+"请求头值: " + headValue);

            if(headName.equalsIgnoreCase("X-Request-chengyunbo")
                    || headName.equalsIgnoreCase("X-Request-cyb")) {
                result = result+headName + "\t " + headValue +" ";
            }
        }
        System.out.println("=============================================");
        String customerId = request.getParameter("customerId");
        System.out.println("request Parameter customerId: "+customerId);

        String customerName = request.getParameter("customerName");
        System.out.println("request Parameter customerName: "+customerName);
        System.out.println("=============================================");

        return R.ok().data("data", "getGatewayFilter 过滤器 test： "+result+" \t "+ DateUtil.now());
    }
}
