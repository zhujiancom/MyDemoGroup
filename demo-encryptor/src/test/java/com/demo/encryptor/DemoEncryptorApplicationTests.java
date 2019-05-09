package com.demo.encryptor;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@Slf4j
public class DemoEncryptorApplicationTests {
    @Autowired
    StringEncryptor encryptor;

    @Test
    public void getPass() {
        String remoteServer = encryptor.encrypt("172.16.150.12");
        String remoteUserName = encryptor.encrypt("appuser");
        String remotePassword = encryptor.encrypt("4300992");
        String cptDir = encryptor.encrypt("/app/apache-tomcat-8087/webapps/WebReport/WEB-INF/reportlets/");
        log.info("encryptServer = "+remoteServer+"----------------");
        log.info("encryptName = "+remoteUserName+"----------------");
        log.info("encryptPassword = "+remotePassword+"----------------");
        log.info("encryptCptDir = "+cptDir+"----------------");
        log.info("----------------------------------------------------------");
        String dbServer = encryptor.encrypt("jdbc:oracle:thin:@127.0.0.1:1521:orcl");
        String dbUserName = encryptor.encrypt("ay01");
        String dbPswd = encryptor.encrypt("password");
        log.info("dbServer = "+dbServer+"----------------");
        log.info("dbUserName = "+dbUserName+"----------------");
        log.info("dbPswd = "+dbPswd+"----------------");
    }

}
