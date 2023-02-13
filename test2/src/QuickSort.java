import java.util.Arrays;

public class QuickSort {

//    public static void main(String[] args) {
//        int[] nums = {2,4,6,1,56,23,45,78,45};
//        if(nums==null || nums.length<2){
//            return;
//        }
//        quickSort(nums, 0, nums.length-1);
//        System.out.println(Arrays.toString(nums));
//    }
//
//    public static void quickSort(int[] nums, int star, int end)
//    {
//        if(star > end){
//            return;
//        }
//        int i = star;
//        int j = end;
//        int key = nums[star];
//        while(i<j){
//            while(i<j && nums[j]>key){
//                j--;
//            }
//            while(i<j && nums[i]<=key){
//                i++;
//            }
//            if(i<j){
//                int tmp;
//                tmp = nums[i];
//                nums[i] = nums[j];
//                nums[j] = tmp;
//            }
//        }
//        nums[star] = nums[i];
//        nums[i] = key;
//        quickSort(nums, star, i-1);
//        quickSort(nums, i+1, end);
//    }

    public static void main(String[] args) {
        int[] nums = {5,7,1,3,4,7,0,6};
        if(nums == null || nums.length<2){
            return;
        }
        quickSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums, int start, int end)
    {
        if(start>end){
            return;
        }
        int i = start;
        int j = end;
        int key = nums[start];
        while (i<j) {
            while(i<j && nums[j]>key){
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
