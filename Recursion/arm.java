public class arm {
    private static int armstrong(int n , int l, int ans){
        if(n==0) return ans;
        ans += Math.pow(n%10 , l);
        return armstrong(n/10 , l , ans);
    }
    public static void main(String[] args) {
        int n = 1;
        int l = 1;
        int ans = 0 ;
        if(armstrong(n,l,ans)==n) System.out.println("yes");
        else System.out.println("no");
    }
}
