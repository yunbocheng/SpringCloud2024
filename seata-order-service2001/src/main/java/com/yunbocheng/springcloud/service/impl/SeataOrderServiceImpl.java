package com.yunbocheng.springcloud.service.impl;

import com.yunbocheng.springcloud.apis.AccountFeignApi;
import com.yunbocheng.springcloud.apis.StorageFeignApi;
import com.yunbocheng.springcloud.entities.Order;
import com.yunbocheng.springcloud.mapper.SeataOrderMapper;
import com.yunbocheng.springcloud.service.SeataOrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-03-14
 */
@Service
@Slf4j
public class SeataOrderServiceImpl implements SeataOrderService {

    private final SeataOrderMapper seataOrderMapper;

    // 订单微服务通过OpenFeign去调用库存微服务
    private final AccountFeignApi accountFeignApi;

    // 订单微服务通过OpenFeign去调用账户微服务
    private final StorageFeignApi storageFeignApi;

    public SeataOrderServiceImpl(SeataOrderMapper seataOrderMapper,
                                 AccountFeignApi accountFeignApi,
                                 StorageFeignApi storageFeignApi) {
        this.seataOrderMapper = seataOrderMapper;
        this.accountFeignApi = accountFeignApi;
        this.storageFeignApi = storageFeignApi;
    }

    @Override
    public Order getOrderById(Long id) {
        return seataOrderMapper.getOrderById(id);
    }

    @Override
    @GlobalTransactional(name = "myGlobalTransactional", rollbackFor = Exception.class)
    public void addOrder(Order order) {

        // xid全局事务id的检查，重要
        String xid = RootContext.getXID();
        // 1 新建订单log
        log.info("------------ 开始新建订单：" + "\t" + "xid：" + xid);
        // 订单新建时默认初始化状态是零
        order.setStatus(0);
        Long addResult = seataOrderMapper.addOrder(order);

        // 查询出插入的订单信息
        Order orderFromDB = null;

        if (addResult > 0) {
            System.out.println(order.getId());
            orderFromDB = seataOrderMapper.getOrderById(order.getId());
            log.info("------- 新建订单成功 ---------");

            //2 扣减库存
            log.info("------- 订单微服务开始调用storage库存，做扣减count");
            storageFeignApi.decrease(orderFromDB.getProductId(), orderFromDB.getCount());
            log.info("------- 订单微服务结束调用storage库存，做扣减完成");

            //3 扣减账户余额
            log.info("------ 订单微服务开始调用account账号，做扣减money");
            accountFeignApi.decrease(orderFromDB.getUserId(), orderFromDB.getMoney());
            log.info("------ 订单微服务结束调用account账号，做扣减完成");

            //4 修改订单状态
            log.info("------ 开始修改订单状态 -------");
            orderFromDB.setStatus(1);
            seataOrderMapper.updateOrderStatusById(orderFromDB);
            log.info("------ 修改订单状态完成 -------");


        }

        log.info("新建订单结束");
    }
}
