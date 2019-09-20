package com.springboot.tcp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import com.springboot.tcp.test.Server;

import java.io.IOException;

@SpringBootApplication
public class TcpApplication extends SpringBootServletInitializer
{

    public static void main(String[] args) throws IOException
    {
        SpringApplication.run(TcpApplication.class, args);
        Server server = new Server();
        server.getServerDemo();//调用开启服务器
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
    {
        return builder.sources(this.getClass());
    }
}