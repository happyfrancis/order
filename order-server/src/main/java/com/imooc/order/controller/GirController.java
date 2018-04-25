/**
 * @program: order
 * @description:
 * @author: Francis
 * @create: 2018-04-20 10:52
 **/

package com.imooc.order.controller;

import com.imooc.order.config.GirlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GirController {

    @Autowired
    private GirlConfig girlConfig;

    @GetMapping("/girl/print")
    public String print(){
        return "name: " + girlConfig.getName() + " age: " + girlConfig.getAge();
    }
}
