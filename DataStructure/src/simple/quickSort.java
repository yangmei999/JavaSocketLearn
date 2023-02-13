package simple;

import java.util.Arrays;

public class quickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4,60,24,45,67,22,57,78};
        if(arr.length==0 || arr.length<2){
            return;
        }
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] nums, int start, int end){
        if(start>=end){
            return;
        }
        int i = start;
        int j = end;
        int key = nums[start];
        while (i<j){
            while(i<j && nums[j]>=key){
                j--;
            }
            while(i<j && nums[i]<=key){
                i++;
            }

            if(i<j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
            nums[start] = nums[i];
            nums[i] = key;
            quickSort(nums, start,i-1);
            quickSort(nums, i+1,end);
        }

    }
}
