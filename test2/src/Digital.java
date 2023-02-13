public class Digital {
    //一个字符串中包含数字和*，将*放到数字的前面
    public static void main(String[] args) {
        char[] chars = new char[] {'1','*','4','3','*','5','*'};
        //操作后，数字的相对位置不变
        //从后向前操作，遇到非*的元素则加入“新”下标中，遍历完毕后，j代表*的个数，将0~j赋值为*即可
        int j = chars.length-1;
        for(int i=j; i>=0; i--){
            if(chars[i] != '*'){
                chars[j--] = chars[i];
            }
        }
        while(j>=0){
            chars[j--] = '*';
        }
        for(char c : chars){
            System.out.println(c + ", ");
        }
    }
}
