package com.ainong.dubbo.hystrix.annotaion;

import com.ainong.dubbo.hystrix.HystrixAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Description: 消费者开启hystrix的注解
 * @author juntao.zhang
 * @version V1.0
 * @Package com.ainong.dubbo.hystrix.annotaion
 * @date 2017/11/29 20:28
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(HystrixAutoConfiguration.class)
public @interface EnableHystrix {
}
