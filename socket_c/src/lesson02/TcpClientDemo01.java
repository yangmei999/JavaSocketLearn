package lesson02;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

//客户端
public class TcpClientDemo01 {
    public static void main(String[] args) {
        //要知道服务器地址
        try {
            InetAddress serverIp = InetAddress.getByName("127.0.0.1");
            int port = 9999;
            //创建一个socket连接
            Socket socket = new Socket(serverIp,port);
            //发送消息 IO流
            OutputStream os = socket.getOutputStream();
            os.write("你好，欢迎学习Java".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
