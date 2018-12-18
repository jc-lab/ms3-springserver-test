package kr.jclab.cloud.ms3.test.ms3springservertest;

import kr.jclab.cloud.ms3.server.spring.EnableMS3SpringServer;
import kr.jclab.cloud.ms3.server.spring.MS3SpringServer;
import kr.jclab.cloud.ms3.server.spring.MS3SpringServerConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.io.File;

@EnableMS3SpringServer
public class MS3ServerConfig implements MS3SpringServerConfigurerAdapter {

    @Autowired
    ApplicationContext applicationContext;

    @Override
    public void configure(MS3SpringServer server) {
        server.setResourceDirectory(new File("D:\\test\\zeroupserver-resource"));
        server.registerRequestMapping("/ms3", Integer.MAX_VALUE - 2);
    }
}
