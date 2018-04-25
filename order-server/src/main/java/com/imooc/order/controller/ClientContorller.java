/**
 * @program: order
 * @description:
 * @author: Francis
 * @create: 2018-04-13 16:05
 **/

package com.imooc.order.controller;

import com.imooc.product.client.ProductClient;
import com.imooc.product.common.DecreaseStockInput;
import com.imooc.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class ClientContorller {

//    @Autowired
//    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    //RestTemplate
    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        //1.第一种方式（直接使用restTemplate,url写死）
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://localhost:8080/msg",String.class);

        //2.第二种方式（利用LoadBalancerClient通过应用名获取url,然后再使用RestTemplate）
//        RestTemplate restTemplate = new RestTemplate();
//        ServiceInstance serviceInstance = loadBalancerClient.choose("product");
//        String url =  String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort(),"/msg");
//        String response = restTemplate.getForObject("http://localhost:8080/msg",String.class);

        //3.第三种方式(利用@LoadBalanced，可在RestTemplate里使用应用名字)
        String response = restTemplate.getForObject("http://product/msg", String.class);

        log.info("response={}", response);
        return response;
    }


    //Feign
    @GetMapping("/getProductMsgCg")
    public String getProductMsgCg() {

        String response = productClient.productMsgCg();
        log.info("response={}", response);
        return response;
    }

    @GetMapping("/getProductList")
    public String getProductList() {
        List<ProductInfoOutput> productInfoList = productClient.listForOrder(Arrays.asList("157875196366160022", "157875227953464068"));
        log.info("response={}", productInfoList);
        return "ok";
    }

    @GetMapping("/productDecreaseStock")
    public String productDecreaseStock() {
        productClient.decreaseStock(Arrays.asList(new DecreaseStockInput("164103465734242707", 3)));
        return "ok";
    }

}
