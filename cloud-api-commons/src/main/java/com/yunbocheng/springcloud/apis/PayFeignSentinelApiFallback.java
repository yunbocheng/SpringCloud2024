package com.yunbocheng.springcloud.apis;

import com.yunbocheng.springcloud.entities.R;
import org.springframework.stereotype.Component;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-03-13
 */
@Component
public class PayFeignSentinelApiFallback implements PayFeignSentinelApi{

    @Override
    public R getPayByOrderNo(String orderNo) {
        return R.error(500,"对方服务宕机或不可用，FallBack服务降级！");
    }
}
