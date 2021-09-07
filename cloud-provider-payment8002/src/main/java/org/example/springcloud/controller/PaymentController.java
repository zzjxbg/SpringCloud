package org.example.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.springcloud.entities.CommonResult;
import org.example.springcloud.entities.Payment;
import org.example.springcloud.service.impl.PaymentServiceImpl8002;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentServiceImpl8002 paymentServiceImpl8002;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentServiceImpl8002.create(payment);
        log.info("*****插入结果: " + result);
        if(result > 0) {
            return new CommonResult(200,"插入数据库成功,serverPort: " + serverPort,result);
        } else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentServiceImpl8002.getPaymentById(id);
        log.info("*****插入结果: " + payment);
        if(payment != null) {
            return new CommonResult(200,"查询成功,serverPort: " + serverPort,payment);
        } else {
            return new CommonResult(444,"没有对应记录,查询ID: " + id,null);
        }
    }
}