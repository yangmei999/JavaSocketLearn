public class RotateArray {
    //翻转数组
    //先翻转前一部分，再翻转后一部分，再整体翻转
    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] array = new int[] {1,2,3,4,5,6,7};
        int k=3;
        rotateArray.rotate(array,k);
        for(int i=0; i<array.length; i++){
            System.out.println(array[i] + " ");
        }
        System.out.println();
    }
    public void rotate(int[] nums, int k)
    {
        if(nums.length == 0 || nums.length == 1 || k%nums.length == 0)
            return;
        k %= nums.length;
        int length = nums.length;
        reverse(nums, 0, length-k-1);
        reverse(nums, length-k, length-1);
        reverse(nums, 0, length-1);
    }
    private void reverse(int[] nums, int begin, int end)
    {
        for(int i=0; i<(end-begin+1)/2; i++){
            int temp = nums[begin+i];
            nums[begin+i] = nums[end-i];
            nums[end-i] = temp;
        }
    }
}
