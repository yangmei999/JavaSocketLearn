import java.util.Arrays;
import java.util.Scanner;

//给出字符串所有字符的排列
// （使用递归，逐渐缩小问题的规模，使用同样的方法解决子问题,要有结束条件
public class permutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        permutation(str.toCharArray(),0);
    }

    private static void permutation(char[] toCharArray, int i) {
        //判空条件
        if(i>=toCharArray.length){
            return;
        }
        if(i==toCharArray.length-1){
            System.out.println(Arrays.toString(toCharArray));
        }else{
            for(int j=i; j<toCharArray.length; j++){
                char temp = toCharArray[j];
                toCharArray[j] = toCharArray[i];
                toCharArray[i] = temp;
                permutation(toCharArray, i+1);
                temp = toCharArray[j];
                toCharArray[j] = toCharArray[i];
                toCharArray[i] = temp;
            }
        }
    }

}
