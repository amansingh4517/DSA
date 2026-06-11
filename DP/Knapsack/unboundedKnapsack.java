package Knapsack;
//unboundedKnapsack is same as 0/1 knapsack but the difference is just that we there is no limit on item we can pick and item as many time as we want
public class unboundedKnapsack {
    public static void main(String[] args) {
        int[] weight = { 3, 5 };
        int[] value = { 4, 7 };
        int capacity = 15;
        System.out.println(recursion(weight, value, capacity, weight.length - 1));
        int[][] memo = new int[weight.length + 1][capacity + 1];
        for (int i = 0; i <= weight.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0)
                    memo[i][j] = 0;
                else
                    memo[i][j] = -1;
            }
        }
        System.out.println(memorization(weight, value, capacity, weight.length, memo));

        int[][] dpMemo = new int[weight.length + 1][capacity + 1];
        System.out.println(dp(weight, value, capacity, weight.length, dpMemo));

    }

// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    static int recursion(int[] w, int[] v, int c, int n) {
        if (n < 0 || c == 0)
            return 0;
        if (w[n] > c)
            return recursion(w, v, c, n - 1);
        else
            return Math.max(v[n] + recursion(w, v, c - w[n], n), recursion(w, v, c, n - 1));
    }


// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    static int memorization(int[] w, int[] v, int c, int n, int[][] memo) {
        if (n == 0 || c == 0)
            return 0;
        if (memo[n][c] != -1)
            return memo[n][c];
        if (w[n - 1] > c)
            memo[n][c] = memorization(w, v, c, n - 1, memo);
        else
            memo[n][c] = Math.max(v[n - 1] + memorization(w, v, c - w[n - 1], n, memo),
                    memorization(w, v, c, n - 1, memo));
        return memo[n][c];
    }


// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    static int dp(int[] w, int[] v, int c, int n, int[][] dpMemo) {
        // NO NEED TO INTIALIZE BECAUSE IT IS BY DEFAULT 0
        // for(int i = 1 ; i <= n ; i++){
        // dpMemo[i][0] = 0;
        // }
        // for(int i = 1 ; i <= c ; i++){
        // dpMemo[0][i] = 0;
        // }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= c; j++) {
                if (w[i - 1] > j)
                    dpMemo[i][j] = dpMemo[i - 1][j];
                else
                    dpMemo[i][j] = Math.max(v[i - 1] + dpMemo[i][j - w[i - 1]], dpMemo[i - 1][j]); //either we choose again or move to next (for unbounded)
            }
        }
        return dpMemo[n][c];
    }

// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    // static int twoArrayDP(int[] w, int[] v, int c, int n){
    //     int[] top = new int[c+1];//same question as unbounded knapsack just in other langauge or situation
    //     int[] curr = new int[c+1];
    //     for(int i = 0 )
    //     for(int j = 1 ; j <= c ; j++){
    //         if(w[j - 1] > c){
    //             curr[j] = curr[j-1];
    //         }
    //         else curr[j] = Math.max(val[j-1] + curr[c - w[j-1

    //         ]])
    //     }
    // }
}
