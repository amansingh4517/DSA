package OOPS;
import java.util.Scanner;
class account{
    Scanner sc = new Scanner(System.in);
    // data security
    private float balance;
    private String name;
    private String password;

    // constructor
    account(String name ,String password ){
        this.name = name ;
        this.password = password;
        this.balance = 0;
    }

    //method :: private (logic for authentication)
    private boolean validate(String name , String password){
        return (this.name.equals(name) && this.password.equals(password))? true : false;
    }

    public void checkBalance(){
        
    }

    public void deposit(int val){
        
    }

    public void withdraw(float val){
        this.balance = val;
    }

    private void setPassword(String val){
        this.password = val;
    }

    public void setPassword(){
        System.out.println("Enter name : ");
        String name = sc.nextLine();
        System.out.print("Enter the old password : ");
        if(validate(name ,sc.nextLine())){
            System.out.println("Enter new password : ");
            String newPass = sc.nextLine();
            System.out.println("Enter new password : ");
            String confPass = sc.nextLine();
            if(newPass.equals(confPass)) {
                setPassword(newPass);
            }
            else System.out.println("New password and confirm password are not matching");
            

        }
        else System.out.println("Wrong credential");
        
    }


}

public class Atm {
    public static void main(String[] args) {
        float var = 1f;
    }
}
