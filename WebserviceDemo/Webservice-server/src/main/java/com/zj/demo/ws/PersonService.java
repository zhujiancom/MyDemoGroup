package com.zj.demo.ws;

import com.zj.demo.ws.entity.Person;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Creator: zhuji
 * Date: 2018/10/14
 * Time: 2:43
 * Description:
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface PersonService {

    @WebMethod
    boolean addPerson(Person person);

    @WebMethod
    boolean deletePerson(int id);

    @WebMethod
    Person getPerson(int id);

    @WebMethod
    Person[] getAllPersons();
}
