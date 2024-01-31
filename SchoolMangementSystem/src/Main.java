import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        boolean exit = false;
        while(exit == false){
            System.out.println("Please enter your username:");
            Scanner input = new Scanner(System.in);
            String userName = input.nextLine();
            System.out.println("Please enter you password");
            String password = input.nextLine();
            Login verify = new Login();
            verify.Login(userName, password);
            System.out.println("If you want to exit enter Y. to continue press any key you want");
            String flag = input.nextLine();
            if(flag.equals("Y") || flag.equals("y")){
                exit = true;
            }
        }
    }
}