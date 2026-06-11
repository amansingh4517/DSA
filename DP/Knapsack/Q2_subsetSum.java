//find the if there is any subset who sum is equal to targetsum;
package Knapsack;
public class Q2_subsetSum {
    public static void main(String[] args) {
        int[] set = { 1, 3, 5, 6, 7, 4, 8 };
        int targetSum = 23;
        System.out.println(recursion(set, set.length, targetSum));

        int[][] memo = new int[set.length + 1][targetSum + 1];
        for (int i = 0; i <= set.length; i++) {
            for (int j = 0; j <= targetSum; j++) {
                if (j == 0)
                    memo[i][j] = 1;
                else if(i==0) memo[i][j] = 0;
                else memo[i][j] = -1;
            }
        }
        
        if ((memorization(set, set.length , targetSum, memo) & 1) == 1)
            System.out.println(true);
        else
            System.out.println(false);


        boolean dpMemo[][] = new boolean[set.length + 1][targetSum + 1];
        for (int i = 0; i <= set.length; i++) {
            for (int j = 0; j <= 0; j++) {
                if (j == 0)
                    dpMemo[i][j] = true;
            }
        }
        dp(set ,set.length , targetSum , dpMemo);
        System.out.println(dpMemo[set.length][targetSum]);

    }

// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

//RECURSION
    static boolean recursion(int[] set, int n, int sum) {
        if (n == 0)
            return false;
        if (sum == 0)
            return true;

        if (set[n - 1] > sum) {
            return recursion(set, n - 1, sum);
        } else {
            return recursion(set, n - 1, sum - set[n - 1]) || recursion(set, n - 1, sum);
        }
    }

// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


// MEMORIZATION
    static int memorization(int[] set, int n, int sum, int[][] memo) {
        if (n == 0)
            return 0;
        if (sum == 0)
            return 1;
        if (memo[n][sum] != -1)
            return memo[n][sum];
        if (set[n-1] > sum) {
            memo[n][sum] = memorization(set, n - 1, sum, memo);
        } else {
            memo[n][sum] = Math.max(memorization(set, n - 1, sum - set[n - 1], memo),
                    memorization(set, n - 1, sum, memo));
        }
        return memo[n][sum];
    }

// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

//DP
    static void dp(int[] set, int n, int sum, boolean[][] dpMemo) {
        for (int i = 1; i <= set.length; i++) {
            for (int j = 1; j <= sum; j++){
                if (set[i - 1] > j)
                    dpMemo[i][j] = dpMemo[i - 1][j];
                else
                    dpMemo[i][j] = dpMemo[i - 1][j] || dpMemo[i - 1][j - set[i-1]];
            }
        }
    }

}
