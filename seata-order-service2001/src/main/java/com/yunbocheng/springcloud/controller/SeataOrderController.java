package com.yunbocheng.springcloud.controller;

import com.yunbocheng.springcloud.entities.Order;
import com.yunbocheng.springcloud.entities.R;
import com.yunbocheng.springcloud.service.SeataOrderService;
import org.springframework.web.bind.annotation.*;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-03-14
 */

@RestController
@RequestMapping("/order")
public class SeataOrderController {

    private final SeataOrderService seataOrderService;

    public SeataOrderController(SeataOrderService seataOrderService) {
        this.seataOrderService = seataOrderService;
    }

    @GetMapping(value = "getOrderById/{id}")
    public R getOrderById(@PathVariable("id") Long id) {
        return R.ok().data("data", seataOrderService.getOrderById(id));
    }

    @PostMapping(value = "/addOrder")
    public void addOrder(@RequestBody Order order) {
        System.out.println(order);
        seataOrderService.addOrder(order);
    }
}
