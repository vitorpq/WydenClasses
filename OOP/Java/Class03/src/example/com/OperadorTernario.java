package example.com;

import java.util.Scanner;

public class OperadorTernario {
    public static void main(String[] args) {
        /* Check if person can drive */

        Scanner scanner = new Scanner(System.in);

        System.out.println("How old are you?: ");
        int age = scanner.nextInt();

        // = ()? if_true : if false;
        String canDrive = (age >= 18) ? "You can drive if you have a license." : "You are not eligible to take a license and drive";

        // if-else
        if (age >= 18){
            System.out.println("You can drive if you have a license.");
        }
        else {
            System.out.println("You are not eligible to take a license and drive.");
        }
        System.out.println(canDrive);

        scanner.close();
    }
}
