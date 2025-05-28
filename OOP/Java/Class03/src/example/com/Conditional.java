package example.com;
import java.util.Scanner;

public class Conditional {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Our DB
        String correctUsername = "admin";
        String correctPassword = "1234";

        // Interact with user
        System.out.println("Enter username: ");
        String username = scanner.nextLine();

        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        // username.equals

        if(username.equals(correctUsername) && password.equals(correctPassword)) {
            System.out.println("Welcome " + username + "!");
        }
        else {
            System.out.println("Invalid username or password");
        }


    }
}
