package Knapsack;
public class Q3_equalSumPartition {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6,5,7,8};
        //we have to divide array in two equal part whose element sum is equal 
        int sum = 0;
        for(int val : arr){
            sum += val;
        }
        //odd + odd = even = even + even
        //if sum  even they it is possible to divide it in two equal part which is sum of each subset 
        if((sum&0)==0){
            // now see that problem as you have a targetSum=sum/2 and you have to find a subset who's sum is eqaul to targetSum
            //if one subset give that sum then other set will atomatically give it
            //now this problem become exactly like EQUAL SUM PARTITION
            // just put set and targetSum = sum/2 if it is even
            System.out.println(recursion(arr ,arr.length , sum/2  ));
            
            int[][] memo = new int[arr.length+1][(sum/2)+1];
        }

        //if sum odd then it is not possible to create two eqaul subset which have same sum and they add up to become odd
        else System.out.println("false");

    }

// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    static boolean recursion(int[] set , int n , int sum  ){
        if(sum == 0) return true;
        if(n==0) return false;
        if(sum>set[n-1]) return recursion(set, n-1, sum);
        else return recursion(set, n-1, sum) || recursion(set , n-1 , sum - set[n-1]);
    }

// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    static int memoization(int[] set , int n , int sum ,int[][] memo){
        if(sum == 0) return 1;
        if(n == 0) return 0;
        if(memo[n][sum]!=-1) return memo[n][sum] ;
        if(sum>set[n-1]) return memo[n][sum] = memoization(set, n-1, sum ,memo);
        else return memo[n][sum] = memoization(set, n-1, sum , memo) || memoization(set , n-1 , sum - set[n-1] , memo);
    }

// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    static int dp(int[] set , int n , int sum ,int dpMemo){
            if(sum == 0) return 1;
            if(n == 0) return 0;
            if(dpMemo[n][sum]!=-1) return dpMemo[n][sum] ;
            if(sum>set[n-1]) return dpMemo[n][sum] = ;
            else return dpMemo[n][sum] = ;
        }
    
}