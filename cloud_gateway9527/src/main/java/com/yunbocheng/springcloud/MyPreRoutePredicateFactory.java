package com.yunbocheng.springcloud;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-03-12
 */
@Component
public class MyPreRoutePredicateFactory extends AbstractRoutePredicateFactory<MyPreRoutePredicateFactory.Config> {

    public MyPreRoutePredicateFactory() {
        super(MyPreRoutePredicateFactory.Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Consumer<Config> consumer) {
        return super.apply(consumer);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("userType");
    }

    @Override
    public Predicate<ServerWebExchange> apply(MyPreRoutePredicateFactory.Config config)
    {
        return new Predicate<ServerWebExchange>()
        {
            @Override
            public boolean test(ServerWebExchange serverWebExchange)
            {
                //检查request的参数里面，userType是否为指定的值，符合配置就通过
                //http://localhost:9527/pay/gateway/get/1?userType=diamond
                String userName = serverWebExchange.getRequest().getQueryParams().getFirst("userType");
                if (userName == null) {
                    return false;
                }
                //如果说参数存在，就和config的数据进行比较
                if(userName.equalsIgnoreCase(config.getUserType())){
                    return true;
                }
                return false;
            }
        };
    }

    @Validated
    @Setter
    @Getter
    public static class Config{
        @NotEmpty
        private String userType;

    }


}
