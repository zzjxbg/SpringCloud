package org.example.springcloud.alibaba.controller;

import org.example.springcloud.alibaba.domain.CommonResult;
import org.example.springcloud.alibaba.domain.Order;
import org.example.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wsk
 * @date 2020/3/25 21:24
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
