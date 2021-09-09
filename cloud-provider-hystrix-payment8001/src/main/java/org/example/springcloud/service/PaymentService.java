package org.example.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    /**
     * 正常访问
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + " paymentInfo_OK,id: " +
                id + "\t" + "O(∩_∩)O哈哈~";
    }

    /**
     * 当前服务不可用了(超时异常、运行异常),做服务降级,兜底的方案都是paymentInfo_TimeOutHandler
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="5000")
    })
    public String paymentInfo_TimeOut(Integer id) {
//        int timeNumber = 5;  //超时异常
//        int age = 10/0;  //运行异常
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: " + Thread.currentThread().getName() + " paymentInfo_TimeOut,id: " +
                id + "\t" + "O(∩_∩)O哈哈~" + " 耗时(秒): ";
    }
    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + " 8001系统繁忙,请稍后再试,id: " +
                id + "\t" + "o(╥﹏╥)o";
    }
}
