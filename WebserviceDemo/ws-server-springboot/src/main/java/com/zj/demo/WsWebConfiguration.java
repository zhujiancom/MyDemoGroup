package com.zj.demo;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 * Creator: zhuji
 * Date: 2018/10/14
 * Time: 14:27
 * Description:
 */
@Configuration
@EnableWs
public class WsWebConfiguration {
//    @Bean
//    public ServletRegistrationBean jaxwsServlet(){
//        ServletRegistrationBean registration = new ServletRegistrationBean(new WSServlet());
//        registration.setName("JAXWSServlet");
//        registration.addUrlMappings("/personWS");
//        return registration;
//    }
//
//    @Bean
//    public ServletListenerRegistrationBean wsServletContextListener(){
//        ServletListenerRegistrationBean listenerRegistrationBean = new ServletListenerRegistrationBean(new WSServletContextListener());
//        return listenerRegistrationBean;
//    }

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");
    }

    @Bean(name = "students")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema studentsSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("StudentPort");
        definition.setTargetNamespace("http://com.zj.demo.ws/students");
        definition.setLocationUri("/ws");
        definition.setSchema(studentsSchema);
        return definition;
    }

    @Bean
    public XsdSchema studentsSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/student-details.xsd"));
    }
}
