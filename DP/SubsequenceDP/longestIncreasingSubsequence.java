package SubsequenceDP;
public class longestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,9,5,3,5,0,8,5};
        LIS(arr , Integer.MIN_VALUE , arr.length);

    }

    private static int LIS(int[] arr , int min , int n){
        if(n==0) return 0;
        if(min==Integer.MAX_VALUE) return LIS(arr , arr[n-1] , n-1);
        if(arr[n-1]<min) {int pick =   1 + LIS(arr , arr[n-1] , n-1) ;}
        int noPick = 1+LIS(arr , arr[n-1] , n-1)
}
}