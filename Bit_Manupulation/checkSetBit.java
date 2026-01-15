
// SET BIT means the in binary which is 1;
// Ex: 010001 0th and 5th bit is set bit
import java.util.Scanner;

public class checkSetBit {
    // Check if the i bit is set bit or not

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 657;
        System.out.println("Binary number : 0000001010010001");
        System.out.print("enter value of i between 0 to 31 : ");
        int i = sc.nextInt();

        // using left shift
        // 1001000
        // 0001000 (1<<i) AND operation
        // -------
        // 0001000
        if ((n & (1 << i)) != 0)
            System.out.println("i is set bit");
        else
            System.out.println("i is not a set bit");

        // using right shift
        // 0001001
        // 0000001 (n>>i) AND operation
        // -------
        // 0000001
        if ((1 & (n >> i)) != 0)
            System.out.println("i is set bit");
        else
            System.out.println("i is not a set bit");
        sc.close();
    }
}
// Ex : 1001000 check if 3rd bit is set bit or not
// suppose agar main us bit ke niche 1 bit la ke & operation perform karu to
// agar upar wala bit 1 hoga tabhi 1 return karega nahi to 0 karega
// 1001000
// 0001000 ye i bit uske niche kaise le ke jae (1<<i)
// -------
// 0001000 agar after operation number 0 se greater hai to set bit tha aur zero
// hai to nahi tha
