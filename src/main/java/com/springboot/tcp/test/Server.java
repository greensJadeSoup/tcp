package com.springboot.tcp.test;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

@Slf4j
public class Server
{
    public void getServerDemo() throws Exception
    {

        ServerSocket server = new ServerSocket(6973);//设置服务器端口号
        System.out.println("服务器开启,等到客户端链接------------------   ");//服务器开启时控制台输出
        while (true) {
            Socket socket = server.accept();
            new Agent(socket).start();
        }
    }

    class Agent extends Thread
    {
        Socket socket = null;

        public Agent(Socket soc)
        {
            this.socket = soc;
        }

        public void run()
        {
            try {
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
                out.write("welcome to Server!\0".getBytes());//给客户端返回信息告知其链接成功
                out.flush();
                byte[] bytes = null;
                while (true){
                    bytes = new byte[100];//大小可更改
                    in.read(bytes);
                    for (byte str:bytes) {
                        System.out.println(str);
                    }
                    //System.out.println("客户端来消息"+ bytes[0]);
                    System.out.println("客户端来消息"+ Arrays.toString(bytes));//由于这里是跟开发板做链接所以全部都必须输入输出为二进制才可以,所以无论传输的是什么都要转换成二进制的形式
                    log.info(Arrays.toString(bytes));      //将客户的消息记录日志
                }
            } catch (Exception e) {
                System.err.println(e);//也可以写成e.printStackTrace();
            }

        }
    }
}