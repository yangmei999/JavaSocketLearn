package com.company;

import com.sun.jmx.snmp.SnmpUnknownMsgProcModelException;

import java.lang.reflect.Array;
import java.util.Arrays;

public class QuickSort01 {
    public static void main(String[] args) {
        int[] nums = {3,1,5,2,7,4,3};
        if(nums == null || nums.length<2){
            return;
        }
        quickSort(nums ,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
    public static void quickSort(int[] nums, int start, int end){
        if(start>=end){
            return;
        }
        int i = start;
        int j = end;
        int key = nums[start];
        while(i<j) {
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
        }
        nums[start] = nums[i];
        nums[i] = key;
        quickSort(nums, start, i-1);
        quickSort(nums, i+1, end);

    }
}
