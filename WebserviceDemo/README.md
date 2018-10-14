<strong><code><font size=6>ws-server-springboot:</font></code></strong>
<pre>
&lt;plugin>
                &lt;groupId>org.codehaus.mojo&lt;/groupId>
                &lt;artifactId>jaxb2-maven-plugin&lt;/artifactId&gt;
                &lt;version>2.2&lt;/version&gt;
                &lt;executions&gt;
                    &lt;execution&gt;
                        &lt;id>xjc&lt;/id&gt;
                        &lt;goals>
                            &lt;goal>xjc&lt;/goal&gt;
                        &lt;/goals>
                    &lt;/execution>
                &lt;/executions>
                &lt;configuration>
                    &lt;packageName>com.zj.demo.jaxb&lt;/packageName>
                    &lt;outputDirectory>${basedir}/target/generated-sources/jaxb&lt;/outputDirectory&gt;
                    &lt;clearOutputDir>false&lt;/clearOutputDir>
                    &lt;<strong>sources</strong>&gt; &lt;!-- 对于2.2版本插件，需要使用sources标签来指定xsd所在的位置 -->
                        &lt;<font color="#DC143C">source</font>&gt;${project.basedir}/src/main/resources/xsd/**&lt;/source>**
                    &lt;<strong>/sources</strong>&gt;
                &lt;/configuration>
            &lt;/plugin>
</pre>
这个项目使用了JAXB maven 插件生成java代码，通过Springboot配置webservice来提供webservice服务，
使用时只需要启动<strong>WsServerSpringbootApplication</strong>即可。

<strong><code><font size=6>Webservice-server:</font></code></strong>
这个项目是原生的模拟webservice服务端

<strong><code><font size=6>Webservice-client:</font></code></strong>
这个项目模拟的是webservice客户端， 使用maven插件jaxws-maven-plugin，通过
配置wsdl 远程地址即可在客户端生成服务器端的entity和service代码
<pre>
    &lt;plugin>
        &lt;groupId>org.codehaus.mojo&lt;/groupId>
        &lt;artifactId>jaxws-maven-plugin&lt;/artifactId>
        &lt;version>2.5&lt;/version>
        &lt;configuration>
            &lt;!--&lt;wsdlDirectory>${basedir}/src/main/resources/wsdl&lt;/wsdlDirectory>-->
            <strong>&lt;wsdlUrls>http://localhost:8888/ws/person?wsdl,http://localhost:8080/ws/students.wsdl&lt;/wsdlUrls></strong>
            &lt;packageName>com.zj.demo.ws&lt;/packageName>
            &lt;destDir>${basedir}/target/classes&lt;/destDir>
            &lt;keep>true&lt;/keep>
            &lt;sourceDestDir>${basedir}/target/generated-sources&lt;/sourceDestDir>
        &lt;/configuration>
        &lt;executions>
            &lt;execution>
                &lt;goals>
                    &lt;goal>wsimport&lt;/goal>
                &lt;/goals>
            &lt;/execution>
        &lt;/executions>
    &lt;/plugin>
</pre>
