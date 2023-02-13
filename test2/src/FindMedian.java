import java.sql.SQLOutput;

public class FindMedian {
    //找中位数，两种方法
    //1.建立最小堆
    //2.找无序数组中的第k大元素，利用快速排序的partition函数
    public static void main(String[] args) {
        int[] arr = {3,5,2,3,5,9,1,2,11,12,13};
        int res = 0;
        if(arr.length%2 == 1){
            res = findMedian(arr, (arr.length+1)/2, 0, arr.length-1);
        }else{
            res = findMedian(arr, arr.length/2, 0, arr.length-1);
        }
        System.out.println(res);
    }
    public static int findMedian(int[] arr, int k, int low, int high)
    {
        if(k>high-low+1) return -1;
        int pos = partition(arr, low, high);
        if(pos-low < k-1){
            return findMedian(arr, k-pos-1, pos+1, high);
        }else if(pos-low == k-1){
            return arr[pos];
        }else{
            return findMedian(arr, k, low, pos-1);
        }
    }

    public static int partition(int[] arr, int low, int high)
    {
        int pivot = arr[low];
        int i=low, j= high;
        while(i<=j){
            while(i<=j && arr[i]<=pivot) i++;
            while(i<=j && arr[j]>=pivot) j--;
            swap(arr,i,j);
        }
        swap(arr,low,j);
        return j;
    }
    public static void swap(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
