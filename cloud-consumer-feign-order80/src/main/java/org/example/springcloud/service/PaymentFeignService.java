package org.example.springcloud.service;

import feign.Param;
import org.example.springcloud.entities.CommonResult;
import org.example.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Feign：接口+注解
 * 微服务调用接口+@FeignClient
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")  //指定调用哪个微服务
public interface PaymentFeignService {

    @GetMapping(value="/payment/get/{id}")   //哪个地址
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value="/payment/feign/timeout")
    public String paymentFeignTimeout();
}
