package com.example.demo.testServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @User: WMJ
 * @create: 2019/9/12
 * @Description: No Description
 */
public class TCPserver {
    public static void main(String[] args) throws IOException {
    /*
     * 创建tcp服务端
     * 思路：
     * 1.创建socket服务端服务，服务端为让客户端可以连上，必须提供端口，监听端口。
     * 2.获取客户端对象，通过客户端的socket流和对应的客户端进行通信
     * 3.获取客户端的socket流的读取流
     * 4.读取数据并显示在服务器端
     * 5.关闭资源
     *
     */
        System.out.println("服务端启动");
        //1.创建服务器端对象
        ServerSocket ss=new ServerSocket(8088);

        //2.获取客户端对象
        Socket s=ss.accept();
        String ip=s.getInetAddress().getHostAddress();//获取id对象的字符对象
        System.out.println(ip+".....connected");

        //3.通过客户端对象获取socket流的读取流
        while (true) {
            InputStream in = s.getInputStream();
            byte[] buf = new byte[1024];
            int len = in.read(buf);
            String str = new String(buf, 0, len);
            System.out.println(str);
            OutputStream outputStream = s.getOutputStream();
            outputStream.write("啦啦啦啦啦啦啦".getBytes());
        }


    }
}
