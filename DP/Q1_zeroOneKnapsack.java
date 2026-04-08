public class Q1_zeroOneKnapsack {

        public static void main(String[] args) {
        int[] weight = { 1, 3, 5, 6, 8 };
        int[] value = { 1, 2, 4, 5, 3 };
        int capacity = 14;

        int[][] memorize = new int[weight.length + 1][capacity + 1];
        // initialize memorize for (n==0||c==0) put 0 otherwise -1;
        for (int i = 0; i <= weight.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0)
                    memorize[i][j] = 0;
                else
                    memorize[i][j] = -1;
            }
        }
        memorization(weight, value, capacity, weight.length, memorize);
        System.out.println(memorize[weight.length - 1][capacity - 1]);

        int[][] dpMemo = new int[weight.length + 1][capacity + 1];
        //no need of intialization it is already zero
        dp(weight, value, capacity, weight.length, dpMemo);
        System.out.println(dpMemo[weight.length][capacity]);
    }

// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    
    // RECURSION(Top-down)
    static int recursion(int[] w, int[] v, int c, int n) {
        if (n == 0 || c == 0)
            return 0;
        if (w[n - 1] > c)
            return recursion(w, v, c, n - 1);
        else {
            return Math.max(v[n - 1] + recursion(w, v, c - w[n - 1], n - 1), recursion(w, v, c, n - 1));
        }
    }

// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    // MEMORIZATION (Top-down)
    static int memorization(int[] w, int[] v, int c, int n, int[][] memorize) {
        if (n == 0 || c == 0)
            return 0;
        // agar koi aisa call aya jo already call ho chuka hai aur uski value hamare
        // pass hai to wahi return kr denge
        if (memorize[n - 1][c - 1] != -1)
            return memorize[n - 1][c - 1];

        // agar nahi hai to calculate and store
        if (w[n - 1] > c) {
            memorize[n - 1][c - 1] = memorization(w, v, c, n - 1, memorize); // we still use recursion call for
                                                                             // calculating value for cell
        } else
            memorize[n - 1][c - 1] = Math.max(v[n - 1] + memorization(w, v, c - w[n - 1], n - 1, memorize),
                    memorization(w, v, c, n - 1, memorize));
        return memorize[n - 1][c - 1];
    }

// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    // DP (Bottom-up)
    static void dp(int[] w, int[] v, int c, int n, int[][] dpMemo) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= c; j++) {
                //same as recursion, instead of returning we calculate it and store in matrix
                if (w[i-1]>j)
                    dpMemo[i][j] = dpMemo[i - 1][j]; //dp sure the previous row and column always filled and the formula always check filled row column for subproblem
                else
                    dpMemo[i][j] = Math.max(v[i - 1] + dpMemo[i - 1][j - w[i-1]], dpMemo[i - 1][j]);
            }
        }
    }

}
