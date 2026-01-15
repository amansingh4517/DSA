public class swapNumbers{
    public static void main(String[] args) {

        //XOR , WORKING -> if even 1's then 0 otherwise 1
        // XOR (^) of same number is 0

        int a = 7; // ( 0111 )
        int b = 3; // ( 0011 )
        System.out.println("BEFORE a : "+a+" b : "+b);

        a = a^b; // a store the value of a^b
        // ( 0111 )^( 0011 ) = ( 0100 ) if even 1's then 0 otherwise 1

        b = a^b; // here a=a^b from previous . So, a^b means (a^b)^b here b^b cancel each other and a is left
        // [( 0111 )^( 0011 )]^( 0011 ) = ( 0100 )^(  0011 ) = ( 0111 ) so, b = 0111 = 7

        a = a^b; // here b=a^b from previous . So, a^b means a^(a^b) here a^a cancel each other and b is left
        // ( 0111 )^[( 0111 )^( 0011 )] = ( 0111 )^(  0100 ) = ( 0011 ) so, a = 0011 = 3

        System.out.println("AFTER a : "+a+" b : "+b);
    }
}
