package com.demo.springboot.starter;

import com.zj.demo.starter.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    public String sayHello(String name){
        return helloWorldService.sayHello(name);
    }
}
