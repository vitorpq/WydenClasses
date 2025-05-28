package example.com;

import java.util.Scanner;

public class SwitchCaso {
    public static void main(String[] args) {
        // Stream = fluxo
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        System.out.print("Enter an operator (+, -): ");
        char operator = scanner.next().charAt(0);

        double result;

        switch(operator) {
            case '+':
                result = num1 + num2;
                System.out.println("Result : " + result);
                break;
            case '-':
                result = num1 - num2;
                System.out.println("Result : " + result);
                break;
            default:
                System.out.println("Error: invalid operator");
                break;
        }
        scanner.close();
    }
}
