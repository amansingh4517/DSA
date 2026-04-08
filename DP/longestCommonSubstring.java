public class longestCommonSubstring {

    public static void main(String[] args) {
        String s1 = "dfkjngjdhdla";
        String s2 = "dgkskgoidghdla";
        StringBuilder ans = new StringBuilder();
        recursion(s1, s2, s1.length(), s2.length(), ans);
        System.out.println(ans);
    }

    public static void recursion(String s1, String s2, int n, int m, StringBuilder ans) {
        if (n == 0 || m == 0)
            return;
        if (s1.charAt(n - 1) == s2.charAt(m - 1)){
            ans.append(s1.charAt(n - 1));
            recursion(s1, s2, n - 1, m-1, ans);
        } 
        else {
            recursion(s1, s2, n - 1, m, ans);
            recursion(s1, s2, n, m - 1, ans);
        }

    }
}
