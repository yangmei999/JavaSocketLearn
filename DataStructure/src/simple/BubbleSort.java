package simple;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,5,1,4,2,6,9};
        if(arr.length==0 || arr.length<2){
            return;
        }
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubbleSort(int[] num){
        for(int i=0; i<num.length-1; i++){
            for(int j=0; j<num.length-1-i; j++){
                if(num[j] > num[j+1]){
                    int tmp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = tmp;
                }
            }
        }
    }
}
