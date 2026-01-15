
public class Binary {

    public static void print(int n) {
    if (n == 0) {
        System.out.println("0");
        return;
    }

    StringBuilder sb = new StringBuilder();

    while (n > 0) {
        sb.append(n & 1);
        n = n >> 1;
    }

    System.out.println(sb.reverse());
}


    // void print(int n) {
    //     while ((n & 1) == 0)
    //         n = n << 1;
    //     while (n != 0) {
    //         if ((n & 1) == 0)
    //             System.out.print("0");
    //         else
    //             System.out.print("1");
    //         n = n << 1;
    //     }
    //     System.out.println();
    // }

}
