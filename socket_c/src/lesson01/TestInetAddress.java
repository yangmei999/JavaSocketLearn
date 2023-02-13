package lesson01;
import java.net.InetAddress;
import java.net.UnknownHostException;

//测试IP
public class TestInetAddress {
    public static void main(String[] args) {
        try {
            //查询本机地址
            InetAddress inetAddress1 = InetAddress.getByName("127.0.0.1");
            System.out.println(inetAddress1);
            InetAddress inetAddress3 = InetAddress.getByName("localhost");
            System.out.println(inetAddress3);
            InetAddress inetAddress4 = InetAddress.getLocalHost();
            System.out.println(inetAddress4);

            //查询网站ip地址
            InetAddress inetAddress2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress2);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
