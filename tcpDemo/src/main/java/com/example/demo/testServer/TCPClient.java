package com.example.demo.testServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @User: WMJ
 * @create: 2019/9/12
 * @Description: No Description
 */
public class TCPClient {
    public static void main(String[] args) throws UnknownHostException, IOException {
    /*
     * tcp客户端的建立。
     * 思路：
     * 1.建立tcp客户端服务
     *   1.1因为是面向连接，必须有链接才可以建立通信
     *   1.2在创建客户端时，就必须明确目的的地址和端口
     * 2.一旦连接确立，就有了传输数据的通道，就可以在通道中传输数据。
     *    这个传输其实是通过流实现的，这个流就是socket io流。
     * 3.只要获取socket io中的写动作就可以将数据写到socket流中给服务端。
     * 4.关闭资源。
     *
     */
        System.out.println("客户端启动。。。");
        //1.创建客户端对象，明确目的地址和端口
        Socket s=new Socket("192.168.16.90",8088);

        //2.获取socket流中的输出流，将数据发送给服务端
        OutputStream out=s.getOutputStream();

        //3.通过输出流写数据
        while(true) {

            out.write("注意啦 ，tcp来了".getBytes());
            InputStream inputStream = s.getInputStream();
            byte[] buf=new byte[1024];
            int len=inputStream.read(buf);
            String str=new String(buf, 0, len);
            System.out.println(str);
        }
    }
}
