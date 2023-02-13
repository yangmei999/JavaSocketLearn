package com.company;

public class quickSort {


    public void quickSort(){
        int[] arr = {5,2,7,9,34,24};
        int tmp = 0;
        for(int i=0; i<=arr.length(); i++){
            for(int j=i+1; j<=i; j++){
                if(arr[j] > arr[j+1]){
                    tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }
}
