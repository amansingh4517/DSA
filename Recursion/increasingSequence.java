
import java.util.Scanner;

class increasingSequence {

    public static void main(String[] arg){

        // Q) print all increasing sequences of length k from first n natural numbers.
        // Ex : n = 4  k =3  then output is 123,124,134,234

        Scanner sc = new Scanner(System.in);
        System.out.print("enter the value of n : ");
        int n = sc.nextInt();
        System.out.print("enter the value of k : ");
        int k = sc.nextInt();

        if(n>9 || n<1) {
            throw new IllegalArgumentException("n must be between 1 and 9");
        }
        if(k>n || k<1) {
            throw new IllegalArgumentException("k must be less than n and greater than 0");
        }

        incSqc2(k,n,"");

    }
    // using 4 param
    public static void incSqc(int i , int k , int n , String ans){
        if(ans.length()==k){
            System.out.println(ans);
            return ;
        }
        if(i==n) return;
        incSqc(i+1,k,n,ans+i);
        incSqc(i+1,k,n,ans);
    }
    // reduce 1 param
    public static void incSqc2(int k , int n , String ans){
        if(ans.length()==k){
            System.out.println(ans);
            return ;
        }
        if(n==0) return;
        incSqc2(k,n-1,n+ans);
        incSqc2(k,n-1,ans);
    }
}