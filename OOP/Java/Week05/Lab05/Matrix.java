package Lab05;

import java.util.Arrays;
import java.util.Random;

public class Matrix {
    private int[][] matrix;
    private int rows;
    private int cols;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = new int[rows][cols];
    }

    public void fillManually(int[][] values) {
        if (values.length != rows || values[0].length != cols) {
            throw new IllegalArgumentException("Dimensions of the provided values do not match the matrix dimensions.");
        }
        this.matrix = values;
    }

    public void fillRandomly() {
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(100); // Fill with random numbers between 0 and 99
            }
        }
    }

    public void sortMatrix(boolean ascending) {
        int[] tempArray = new int[rows * cols];
        int index = 0;

        // Copy elements from matrix to tempArray
        for (int[] row : matrix) {
            for (int elem : row) {
                tempArray[index++] = elem;
            }
        }

        // Sort the tempArray
        Arrays.sort(tempArray);

        if (!ascending) {
            reverseArray(tempArray);
        }

        // Copy sorted elements back to the matrix
        index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = tempArray[index++];
            }
        }
    }

    private void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public void printMatrix() {
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }
}
