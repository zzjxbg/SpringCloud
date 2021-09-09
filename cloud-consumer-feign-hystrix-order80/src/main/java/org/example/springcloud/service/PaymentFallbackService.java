package org.example.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * 为Feign客户端定义的接口添加一个服务降级处理的实现类即可实现服务降级和业务代码的解耦
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "----PaymentFallbackService fall back-paymentInfo_OK,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----PaymentFallbackService fall back-paymentInfo_TimeOut,o(╥﹏╥)o";
    }
}
