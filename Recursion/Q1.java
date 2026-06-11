import java.util.*;

public class Q1 {
    static public class Pair {
        String str;
        int len;

        Pair(String s) {
            this.str = s;
            this.len = 0;
        }
        Pair(String s , int n) {
            this.str = s;
            this.len = n;
        }
    }

    private static ArrayList<String> ans = new ArrayList<>();

    private static void perm(String input, Pair p, int n) {
        StringBuilder st = new StringBuilder(p.str);
        if (p.len == st.length()) {
            System.out.println(p.str);
            ans.add(p.str);
            return;
        }
        st.append(input.charAt(p.len)); // add alphabet
        Pair NoOne = new Pair(st.toString() , p.len+1);
        perm(input, NoOne, n);
        st.deleteCharAt(st.length() - 1); // undo previous update
        // if previous char is number add one in it
        if (p.len >= 1) {
            char ch = p.str.charAt(p.len - 1); //
            ch = (Character.isDigit(ch)) ? (char) (ch - '0' + 1) : ch;
            st.append(ch); // add alphabet
            Pair One = new Pair(st.toString() , p.len+1);
            perm(input, One, n);
        }

    }

    public static void main(String[] args) {
        String st = "HAT";
        Pair p = new Pair("");
        perm(st, p, st.length());
        System.out.println(ans);
    }
}