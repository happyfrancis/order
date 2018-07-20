package com.imooc.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @program: order
 * @description:
 * @author: Francis
 * @create: 2018-04-27 15:20
 **/
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
//回调方法又称服务降级方法
public class HystrixController {

    //服务降级
    //@HystrixCommand(fallbackMethod = "fallback")

    //使用类上默认回调方法
    //@HystrixCommand

    //超时配置
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//    })

    //熔断配置
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "circuitBreaker.enabled",value ="true" ),//设置断路器开启
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10" ),//设置在滚动时间窗口中断路器的最小请求数
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000" ),//在这段时间将一直调用回调函数（熔断函数）
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//设置断路器打开的错误百分比条件 60%
//    })

    @HystrixCommand //可以把相关配置都写到启动配置文件中
    @GetMapping("/getProductInfoList")
    public String getProductInfoList(@RequestParam("number") Integer number){
        if(number % 2 == 0){
            return "success";
        }
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://127.0.0.1:8004/product/listForOrder",
                Arrays.asList("157875196366160022"),
                String.class);

//        throw new RuntimeException("发送异常了");
    }

    private String fallback(){
        return "太拥挤了，请稍后再试。。。。";
    }

    private String defaultFallback(){
        return "默认提示：太拥挤了，请稍后再试。。。。";
    }
}
