package com.company;

import java.util.Arrays;

public class Main {

    //快速排序：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据小，然后按此方法对这两部分数据分别进行快速排序，整个排序可以递归进行，以此达到整个数据编程有序序列
    //从数组中选一个数作为基准值，选第一个数或者最后一个数
    //采用双指针遍历，从左向右找到比基准值大的第一个数，从右向左找到比基准值小的第一个数，交换位置，直到头尾指针或头指针大于尾指针，把基准值与头指针的数交换，
    //对左边的数列，重复上述操作，对右边的数列重复上述操作
    //左右两边数列递归结束后，排序完成
    public static void main(String[] args) {
	    int[] nums = {2,4,6,1,56,23,45,78,45};
//        if(nums==null || nums.length<2){
//            return;
//        }
        quickSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums, int star, int end)
    {
        if(star > end){
            return;
        }
        int i = star;
        int j = end;
        int key = nums[star];
        while(i<j){
            while(i<j && nums[j]>key){
                j--;
            }
            while(i<j && nums[j]<=key){
                i++;
            }
            if(i<j){
                int tmp;
                tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
            }
        }
        nums[star] = nums[i];
        nums[i] = key;
        quickSort(nums, star, i-1);
        quickSort(nums, i+1, end);
    }
}
