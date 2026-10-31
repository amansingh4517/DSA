package OOPS;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        BigNumber a = new BigNumber("10009");
        BigNumber b = new BigNumber("108");
        a.printNumber();
        b.printNumber();
        System.out.print("addition : ");
//        a.add(b);
        a.printNumber();
        System.out.println();
        System.out.print("subtraction : ");
        a.mag_Subtract(b);
        a.printNumber();
    }

}




class Digit {
    int val;
    Digit next;
    Digit pre;

    Digit(int val) {
        this.val = val;
    }
}




class BigNumber {
    private int digits = 0;
    private char sign = '+';
    private Digit head;
    private Digit tail;



    public BigNumber(String s) {
        Digit temp = null;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                sign = s.charAt(i);
                continue;
            }

            Digit new_digit = createDigit(s.charAt(i) - '0');

            if (this.head == null) {
                this.head = new_digit;
                this.tail = new_digit;
                temp = this.head;

            } else {
                temp.next = new_digit;
                new_digit.pre = temp;
                temp = temp.next;
            }
            this.tail = temp;
        }

        normalize();
    }

    private Digit createDigit(int val){
        digits++;
        return new Digit(val);
    }

    public void normalize(){
        while(this.head.val == 0){
            this.head = this.head.next;
            this.head.pre = null;
            digits--;
        }
    }


    public void printNumber() {
        Digit temp = this.head;
        System.out.print((this.sign == '-') ? '-' : "" + "");
        while (temp != null) {
            System.out.print(temp.val + "");
            temp = temp.next;
        }
        System.out.println();
    }


    public int compareTo(BigNumber num) {
        if (this.digits > num.digits) return 1;
        if (this.digits < num.digits) return -1;

        Digit temp1 = this.head;
        Digit temp2 = num.head;

        while (temp1 != null) {
            if (temp1.val > temp2.val) return 1;
            if (temp1.val < temp2.val) return -1;

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return 0;
    }


    public void add(BigNumber num) {
        if (this.sign == '-' && num.sign == '-')
            this.sign = '-';
        int carry = 0;
        Digit temp1 = this.tail, temp2 = num.tail;
        while (temp1 != null && temp2 != null) {
            int result = temp1.val + temp2.val + carry;
            temp1.val = result % 10;
            carry = result / 10;
            temp1 = temp1.pre;
            temp2 = temp2.pre;
        }
        while (temp1 != null) {
            int result = temp1.val + carry;
            temp1.val = result % 10;
            carry = result / 10;
            temp1 = temp1.pre;
        }
        while (temp2 != null) {
            int result = temp2.val + carry;
            Digit new_node = createDigit(result % 10);
            new_node.next = this.head;
            this.head.pre = new_node;
            this.head = new_node;
            carry = result / 10;
            temp2 = temp2.pre;
        }
        if (carry > 0) {
            Digit new_node = createDigit(carry);
            new_node.next = this.head;
            this.head.pre = new_node;
            this.head = new_node;
        }

    }


    public void mag_Subtract(BigNumber num) {
         Digit g , s;
         int compareResult = compareTo(num);

         //both number are equal
         if(compareResult == 0) {
            this.head = new Digit(0);
            return ;
         }

         else{
            if(compareResult == 1) {
               g = this.tail;
               s = num.tail;
            }
            else {
                s = this.tail;
               g = num.tail;
            }
         }

       Digit ans = null ;
         int borrow = 0;
       
        while (g != null && s != null) {
            if(g.val<s.val){
                Digit new_node = createDigit((g.val-borrow+10) - s.val);
                if(ans == null) ans = new_node;
                else {
                    ans.pre = new_node;
                    new_node.next = ans;
                }
                borrow = 1;
            }
            else {
                if(borrow > 0 && g.val == 0; ){
                    borrow = 1;
                    g.val = 10;
                }
                Digit new_node = createDigit(g.val - borrow - s.val);
                if(ans == null) ans = new_node;
                else {
                    ans.pre = new_node;
                    new_node.next = ans;
                }
                borrow = 0;
            }
            g = g.pre;
            s = s.pre;
            if(ans.pre!=null) ans = ans.pre;
        }
        while(g!=null){
            Digit new_node = createDigit(g.val);
            new_node.next = ans;
            ans.pre = new_node;
            this.head = new_node;
            ans = ans.pre;
            g = g.pre;

        }

        this.head = ans;

        normalize();
        

    }

}
