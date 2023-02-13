////在给定数组中，找到需要排序的最短子数组长度
//
//public class GetMinLength {
//    public static void getMinLength(int [] arr){
//        if(arr == null || arr.length<2){
//            return 0;
//        }
//        int min = arr[arr.length-1];
//        int MinIndex = -1;
//        for(int i = arr.length-2; i!=-1; i--){
//            if(arr[i] >min){
//                MinIndex = i;
//            }else{
//                min = Math.min(min,arr[i]);
//            }
//        }
//        if(MinIndex == -1)
//            return 0;
//        int max = arr[0];
//        int MaxIndex = -1;
//        for(int i=1; i!= arr.length; i++){
//            if(arr[i] <max){
//                MaxIndex = i;
//            }else{
//                max = Math.max(max, arr[i]);
//            }
//        }
//    }
//}
