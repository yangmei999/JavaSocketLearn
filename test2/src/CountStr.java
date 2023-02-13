import java.util.Scanner;

public class CountStr {
    public static void main(String[] args) {
        int charCount = 0;
        int digital = 0;
        int other = 0;
        int blank = 0;
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] ch = s.toCharArray();
        for(int i = 0; i<ch.length-1; i++){
            if(ch[i] >= '0' && ch[i] <= '9'){
                digital++;
            }else if((ch[i]>='a' && ch[i]<='z')||(ch[i]>='A' && ch[i]<='Z')){
                charCount++;
            }else if(ch[i] == ' '){
                blank++;
            }else{
                other++;
            }
        }
        System.out.println("数字的个数：" + digital);
        System.out.println("字母的个数：" + charCount);
        System.out.println("空格的个数：" + blank);
        System.out.println("其他字符的个数：" + other);
    }
}
