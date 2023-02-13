public class ChangeOrder {
    //反转句子的顺序
    //通过字符交换实现，字符串换位字符数组，
    // 然后定义两个索引分别指向数组的首尾，再交换两个索引位置的值。
    // 同时把两个索引的值向中间移动，直到两个索引相遇为止

    //将字符串倒置；；倒置字符
    public static void main(String[] args) {
        String str = "i am yangmei";
        String res = changeOrder(str);
        System.out.println(res);
    }
    public static String changeOrder(String str)
    {
        char[] arr= str.toCharArray();
        int begin = 0, end = 0;
        int i = 0;
        int strLen = arr.length;
        swap(arr, i, strLen-1);
        for(int k=0; k<arr.length; k++){
            if(arr[k] != ' '){
                begin = k;
                while((arr[k] != ' ') && ((k+1)<arr.length)){
                    k++;
                }
                if(k == arr.length-1){
                    end = arr.length-1;
                }else{
                    end = k-1;
                }
            }
            swap(arr, begin, end);
        }
        String result = String.copyValueOf(arr);//字符数组生成字符串
        return result;
    }
    public static void swap(char[] arr, int begin, int end)
    {
        while(end>begin){
            char temp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = temp;
            end--;
            begin++;
        }
    }
}
