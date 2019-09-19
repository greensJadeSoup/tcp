package com.springboot.tcp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import com.springboot.tcp.test.Server;

@Slf4j
@SpringBootApplication
public class TcpApplication extends SpringBootServletInitializer {

    public static void main(String[] args)
    {
        SpringApplication.run(TcpApplication.class, args);
        Server server = new Server();
        try {
            server.getServerDemo();//调用开启服务器
        } catch (Exception e) {
            log.error(e.getMessage());//记录日志
//            e.printStackTrace();
        }
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
    {
        return builder.sources(this.getClass());
    }
}
