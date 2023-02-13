package lesson03;

import java.net.*;

public class UdpclientDemo01 {
    public static void main(String[] args) throws Exception {
        //1.建立一个Socket
        DatagramSocket socket = new DatagramSocket();
        //2.建个包
        String msg = "你好啊！服务器！";
        //发送给谁
        InetAddress localhost = InetAddress.getByName("localhost");
        int port = 9090;
        //数据，数据的长度起始，要发送给谁
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, localhost, port);
        //3.发送包
        socket.send(packet);
        System.out.println("已经发送成功");
        //4.关闭源
        socket.close();
    }
}
