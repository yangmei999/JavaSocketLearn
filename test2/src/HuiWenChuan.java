import java.util.Scanner;

public class HuiWenChuan {
    static String string;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        System.out.println("请输入要检验的串：");
        string = sc.next();
        if(huiWenChuan(string)){
            s = "是回文串";
        }else{
            s = "不是回文串";
        }
        System.out.println(s);
    }
    public static boolean huiWenChuan(String string)
    {
        int low = 0;
        int high = string.length()-1;
        while(low<high){
            //检查对称位置是否一致
            if(string.charAt(low) != string.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }
}
