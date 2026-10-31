package SlidingWindow;

public class MaximumSumSubarrayOfSizeK {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4,5,6,3,7,8,90,5};
        int k = 4;
        int sum =0  , max = 0;
        for(int i = 0 ; i < k ; i++){
            sum += arr[i];
        }
        max = Math.max(sum , max);
        for(int i = k ; i < arr.length ; i++ ){
            sum += arr[i];
            sum -= arr[i-k];
            max = Math.max(sum , max);
        }
        System.out.println(max);
    }
}
