package SubsequenceDP;
public class printLongestCommonSubsequence {
    
    public static void main(String[] args) {
        String s1 = "agkfhtlsj";
        String s2 = "agftlsglhesj";
        System.out.println(recursion(s1, s2, s1.length(), s2.length()));
        int[][] memo = new int[s1.length()+1][s2.length()+1];
         for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length() ; j++) {
                memo[i][j] = -1;
            }
        }
        System.out.println(memoization(s1, s2, s1.length(), s2.length(),memo));
        int[][] dpMemo = new int[s1.length()+1][s2.length()+1];
        System.out.println(dp(s1, s2, s1.length(), s2.length(), dpMemo));

    }

// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    static int recursion(String s1, String s2, int n, int m) {
        if (n == 0 || m == 0)
            return 0;
        if (s1.charAt(n-1) == s2.charAt(m-1))
            return 1 + recursion(s1, s2, n - 1, m - 1);
        else
            return Math.max(recursion(s1, s2, n, m - 1), recursion(s1, s2, n - 1, m));
    }

// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    static int memoization(String s1, String s2, int n, int m, int[][] memo) {
        if (n == 0 || m == 0)
            return 0;
        if (memo[n][m] != -1)
            return memo[n][m];
        if (s1.charAt(n-1) == s2.charAt(m-1))
            memo[n][m] =1 + memoization(s1, s2, n - 1, m - 1 , memo);
        else
            memo[n][m] = Math.max(memoization(s1, s2, n, m - 1, memo), memoization(s1, s2, n - 1, m , memo));
        return memo[n][m];
    }

// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    static int dp(String s1, String s2, int n, int m, int[][] dpMemo) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    dpMemo[i][j] = 1 + dpMemo[i-1][j-1];
                else
                    dpMemo[i][j] = Math.max(dpMemo[i-1][j] , dpMemo[i][j-1]);
            }
        }
        return dpMemo[n][m];
    }
}
