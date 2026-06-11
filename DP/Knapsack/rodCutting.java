package Knapsack;

public class rodCutting {
    // same question as unbounded knapsack just in other langauge or situation
    public static void main(String[] args) {
        int[] rod = { 1, 2 };
        int[] val = { 1, 4 };
        int length = 5;

        System.out.println(recursion(rod, val, rod.length, length));
        int[][] memo = new int[rod.length + 1][length + 1];
        for (int i = 1; i <= rod.length; i++) {
            for (int j = 1; j <= length; j++) {
                memo[i][j] = -1;
            }
        }
        System.out.println(memoization(rod, val, rod.length, length, memo));
        int[][] dpMemo = new int[rod.length + 1][length + 1];
        System.out.println(dp(rod, val, rod.length, length, dpMemo));

    }

// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    static int recursion(int[] r, int[] v, int n, int l) {
        if (n == 0 || l == 0)
            return 0;
        if (r[n - 1] > l)
            return recursion(r, v, n - 1, l);
        else
            return Math.max(v[n - 1] + recursion(r, v, n, l - r[n - 1]), recursion(r, v, n - 1, l));
    }

// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    static int memoization(int[] r, int[] v, int n, int l, int[][] memo) {
        if (n == 0 || l == 0)
            return 0;
        if (memo[n][l] != -1)
            return memo[n][l];
        if (r[n - 1] > l)
            return memo[n][l] = recursion(r, v, n - 1, l);
        else
            return memo[n][l] = Math.max(v[n - 1] + recursion(r, v, n, l - r[n - 1]), recursion(r, v, n - 1, l));
    }

// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    static int dp(int[] r, int[] v, int n, int l, int[][] dpMemo) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= l; j++) {
                if (r[i - 1] > j)
                    dpMemo[i][j] = dpMemo[i - 1][j];
                else
                    dpMemo[i][j] = Math.max(v[i - 1] + dpMemo[i][j - r[i - 1]], dpMemo[i - 1][j]);
            }
        }
        return dpMemo[n][l];

    }

}
