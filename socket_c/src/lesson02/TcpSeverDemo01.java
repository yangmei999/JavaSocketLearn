package lesson02;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务器端
public class TcpSeverDemo01 {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream baos = null;
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        //服务器自己需要有一个地址
        try {
            serverSocket = new ServerSocket(9999);
            //等待客户端连接过来
            socket = serverSocket.accept();
            //读取客户端的消息
            is = socket.getInputStream();

            //管道流
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while((len=is.read(buffer))!=-1){
                baos.write(buffer,0,len);
            }
            System.out.println(baos.toString());


            /*
            byte[] buffer = new byte[1024];
            int len;
            while((len=is.read(buffer)) != -1){
                String s = new String(buffer, 0, len);
                System.out.println(msg);
            }
            */

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if(is != null){
                try{
                    baos.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }

            is.close();
            socket.close();
            serverSocket.close();
        }
    }
}
