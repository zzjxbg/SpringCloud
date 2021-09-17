package org.example.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() throws InterruptedException {
        //暂停3s
        TimeUnit.MILLISECONDS.sleep(3000);
        return "-----testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t" + "...testB");
        return "-----testB";
    }


    @GetMapping("/testD")
    public String testD()
    {
//        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
//        log.info("testD 测试RT");
        log.info("testD 异常比例");
        int age = 10/0;
        return "------testD";
    }

    @GetMapping("/testE")
    public String testE()
    {
        log.info("testE 测试异常数");
        int age = 10/0;
        return "------testE 测试异常数";
    }

    /**
     * @SentinelResource: 处理的是Sentinel控制台配置的违规情况,有blockHandler方法配置的兜底处理
     * RuntimeException: int age = 10/0,java运行时报出的运行时异常,@SentinelResource不管
     * @return
     */
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value="p1",required = false) String p1,
                             @RequestParam(value="p2",required = false) String p2) {
        return "-------testHotKey";
    }
    public String deal_testHotKey(String p1, String p2, BlockException exception) {
        return "-----deal_testHotKey,o(╥﹏╥)o";  //sentinel系统默认提示:Blocked by Sentinel(flow limiting)
    }

}
