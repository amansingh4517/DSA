
//clear bit mean making the i bit 0 if its 1 

import java.util.Scanner;

public class clearBit {
    // bring 1 just below the the bit you want to clear and perform such operation
    // which make the bit above it 0, if its 1
    // and do not affect other bits
    // 011 | 010 = 011
    // 011 & 010 = 010
    // 011 ^ 010 = 001 worked
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 10;
        System.out.print("Binary number : ");
        Binary.print(n);
        System.out.print("enter value of i between 0 to 31 : ");
        int i = sc.nextInt();
        n = n ^ (1 << i);
        Binary.print(n);

    }
}
