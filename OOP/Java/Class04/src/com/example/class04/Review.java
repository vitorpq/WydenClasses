package com.example.class04;
import java.util.Scanner;
/**
 * <p>This is a simple JavaDoc comment.</p>
 * HTML tags
 * <H1>Javadoc Tags</H1>
 * @author vitor
 * @version 0.0.1
 * @since - qdo o código foi introduzido
 * //@throws - @exceptions
 * @see #fatorial(int)
 * @deprecated -
 * @summary descrição breve em pacotes
 * @docRoot -
 */
public class Review {
    /**
     * Função que retorna o fatorial de um numero (n) fornecido pelo usuário.
     * @param n - número inteiro
     * @return - retorna um tipo long do fatorial de n.
     */
    public static long fatorial(int n) {
        long resultado = 1;
        for (int i = 1; i <= n; i++)
        {
            resultado *= i;
        }
        return resultado;
    }

    public static long fatorialWhile(int n) {
        long resultado = 1;
        int i = 1;
        while(i <= n)
        {
            resultado *= i;
            i += 1;
        }
        return resultado;
    }

    public static long fatorialDowhile(int n) {
        long resultado = 1;
        int i = 1;
        do
        {
            resultado *= i;
            i++;
        } while(i <= n);
        return resultado;
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Entre um número inteiro: ");
        int number = scanner.nextInt();

        long resultado = fatorialWhile(number);

        System.out.println("O fatorial de " + number + " é: " + resultado);
        System.out.printf("O fatorial de %d é %d", number, resultado);

        scanner.close();

    }
}
