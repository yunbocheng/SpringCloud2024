package com.yunbocheng.springcloud.controller;

import com.yunbocheng.springcloud.entities.R;
import com.yunbocheng.springcloud.service.SeataStorageService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-03-14
 */
@RestController
@RequestMapping("/storage")
public class SeataStorageController {

    private final SeataStorageService seataStorageService;

    public SeataStorageController(SeataStorageService seataStorageService) {
        this.seataStorageService = seataStorageService;
    }

    @GetMapping(value = "/getStorageById/{id}")
    public R getStorageById(@PathVariable("id") Long id) {
        return R.ok().data("data", seataStorageService.getStorageById(id));
    }

    @PostMapping(value = "/decrease")
    public void decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        seataStorageService.decrease(productId, count);
    }

}
