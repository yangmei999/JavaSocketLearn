import java.lang.reflect.Array;
import java.util.Arrays;

public class FindMinMax {
    public static void main(String[] args) {
        largestAndSmallest (new int[] {-20,34,21,-87,92,Integer.MAX_VALUE});
        largestAndSmallest (new int[] {10,Integer.MAX_VALUE,-2});
        largestAndSmallest (new int[] {Integer.MAX_VALUE,40,Integer.MAX_VALUE});
        largestAndSmallest (new int[] {1,-1,0});
    }
    public static void largestAndSmallest(int[] nums)
    {
        int lagest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for(int num : nums){
            if(num>lagest){
                lagest = num;
            }else if (num<smallest){
                smallest = num;
            }
        }
        System.out.println("给出的数组：" + Arrays.toString(nums));
        System.out.println("数组中最大的数：" + lagest);
        System.out.println("数组中最小的数：" + smallest);
    }
}
