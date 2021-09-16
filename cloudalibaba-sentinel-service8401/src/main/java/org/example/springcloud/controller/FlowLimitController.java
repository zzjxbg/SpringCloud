package org.example.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() throws InterruptedException {
        //暂停3s
        TimeUnit.MILLISECONDS.sleep(3000);
        return "-----testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "-----testB";
    }
}
