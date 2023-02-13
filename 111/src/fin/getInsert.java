package fin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class getInsert {
    public static void main(String[] args) {
         int[] arr1 = new int[]{1,3,8,4,6};
         int[] arr2 = new int[]{3,4,9,7,8};
         int[] res = res(arr1, arr2);
         for(int num : arr2){
             System.out.println(num);
         }

    }
    public static int[] res(int[] arr1, int[] arr2){
        if(arr1.length > arr2.length){
            return res(arr2,arr1);
        }
        Map<Integer,Integer> arr1Map = new HashMap<>();
        //统计arr1数组的元素
        for(int num : arr1){
            int count = arr1Map.getOrDefault(num,0)+1;
            arr1Map.put(num,count);
        }
        int[] inter_num = new int[arr1.length];
        int index = 0;

        //统计arr2数组的元素
        for(int num : arr2){
            int count = arr1Map.getOrDefault(num,0);
            if(count>0){
                inter_num[index++] = num;
                count--;
                if(count==0){
                    arr1Map.remove(num);
                }else{
                    arr1Map.put(num,count);
                }
            }
        }
        return Arrays.copyOfRange(inter_num,0,index);
    }
}
