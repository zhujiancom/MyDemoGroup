package com.zj.demo;

import com.zj.demo.ws.TestService;
import com.zj.demo.ws.impl.PersonServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * Creator: zhuji
 * Date: 2018/10/14
 * Time: 2:48
 * Description:
 */
public class SAOPPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8888/testWS", new TestService());
        Endpoint.publish("http://localhost:8888/ws/person", new PersonServiceImpl());
    }
}
