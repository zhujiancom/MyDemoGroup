package com.zj.demo.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

/**
 * Creator: zhuji
 * Date: 2018/10/14
 * Time: 2:22
 * Description:
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class TestService {

    @WebMethod
    public String hello(String msg) {
        return "Hello " + msg;
    }
}
