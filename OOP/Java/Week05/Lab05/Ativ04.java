package Lab05;

import java.util.Scanner;

public class Ativ04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitando tamanho da matriz
        System.out.println("Digite o número de linhas: ");
        int rows = scanner.nextInt();
        System.out.println("Digite o número de colunas: ");
        int cols = scanner.nextInt();

        Matrix matrix = new Matrix(rows, cols);

        // Solicitando modo de preenchimento da matriz
        System.out.println("Deseja preencher a matriz manualmente (1) ou aleatoriamente (2)?");
        int fillOption = scanner.nextInt();

        if (fillOption == 1) {
            int[][] values = new int[rows][cols];
            System.out.println("Digite os elementos da matriz:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    values[i][j] = scanner.nextInt();
                }
            }
            matrix.fillManually(values);
        } else {
            matrix.fillRandomly();
        }

        // Exibindo a matriz preenchida
        System.out.println("Matriz preenchida:");
        matrix.printMatrix();

        // Solicitando tipo de ordenação
        System.out.println("Deseja ordenar a matriz em ordem crescente (1) ou decrescente (2)?");
        int sortOption = scanner.nextInt();

        boolean ascending = sortOption == 1;

        // Ordenando e exibindo a matriz
        matrix.sortMatrix(ascending);
        System.out.println("Matriz ordenada:");
        matrix.printMatrix();
    }
}