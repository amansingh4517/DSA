package SubsequenceDP;

public class longestCommonSubstring {

    public static void main(String[] args) {
        String s1 = "forgeeksskeegfor";
        String s2 = "rofgeeksskeegrof";
        int max = 0;
        // StringBuilder ans = new StringBuilder();
         recursion(s1, s2, s1.length(), s2.length(),0);
        System.out.println(max);
    }
    
    public static void recursion(String s1, String s2, int n, int m,int ans ) {
        if (n == 0 || m == 0)
            return;
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            if(ans>max) max = ans;
            recursion(s1, s2, n - 1, m - 1, ans + 1);
        } else {
            recursion(s1, s2, n - 1, m, 0);
            recursion(s1, s2, n, m - 1, 0);
        }

    }
}
