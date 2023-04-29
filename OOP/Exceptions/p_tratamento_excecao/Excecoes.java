//package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Excecoes {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		method1();
		
		System.out.println("End of program!!!");
	}
	
	public static void method1() {
		System.out.println("Method1 Start");
		method2();
		System.out.println("Method1 End");
	}
	
	public static void method2() {
		System.out.println("Method2 Start");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter witch vector of string? ");
			String[] vector = sc.nextLine().split(" ");
			
			System.out.println("Enter witch a position: ");
			int position = sc.nextInt();
			System.out.println(vector[position]);
		// Valor fora do indice do array
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid position!!!");
			
			// Exibe a chamada de metodos (pilha) quando ocorreu a excecao
			e.printStackTrace();
			sc.next();
		// Valor Invalido
		} catch (InputMismatchException e) {
			System.out.println("Invalid number!!!");
		}

		System.out.println();
		System.out.println("programa continua");

		sc.close();
		System.out.println("Method2 End");
	}
}
