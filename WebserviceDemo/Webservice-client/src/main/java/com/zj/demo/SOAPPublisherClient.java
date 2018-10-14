package com.zj.demo;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import com.zj.demo.ws.Person;
import com.zj.demo.ws.PersonService;
import com.zj.demo.ws.PersonServiceImplService;

/**
 * Creator: zhuji
 * Date: 2018/10/14
 * Time: 2:41
 * Description:
 */
public class SOAPPublisherClient {

    public static void main(String[] args) {
//        try {
//            URL wsdlURL = new URL("http://localhost:8888/ws/person?wsdl");
//            //check above URL in browser, you should see WSDL file
//
//            //creating QName using targetNamespace and name
//            QName qname = new QName("http://impl.ws.demo.zj.com/", "PersonServiceImplService");
//
//            Service personService = Service.create(wsdlURL, qname);

            //We need to pass interface and model beans to client
//            PersonService ps = personService.getPort(PersonService.class);
            PersonServiceImplService pss = new PersonServiceImplService();
            PersonService ps = pss.getPersonServiceImplPort();

            Person p1 = new Person();
            p1.setName("Pankaj");
            p1.setId(1);
            p1.setAge(30);
            Person p2 = new Person();
            p2.setName("Meghna");
            p2.setId(2);
            p2.setAge(25);

            //add person
            System.out.println("Add Person Status=" + ps.addPerson(p1));
            System.out.println("Add Person Status=" + ps.addPerson(p2));

            //get person
            System.out.println(ps.getPerson(1));

            //get all persons
            System.out.println(Arrays.asList(ps.getAllPersons()));

            //delete person
            System.out.println("Delete Person Status=" + ps.deletePerson(2));

            //get all persons
            System.out.println(Arrays.asList(ps.getAllPersons()));
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
    }
}
