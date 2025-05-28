package com.example.class04;//package com.example.class04;

import java.util.Random;

public class GameOfLife {
    private int size;
    private int[][] grid;

    // Step 1: Define the Grid Class
    public GameOfLife(int size) {
        this.size = size;
        this.grid = new int[size][size];
        initializeGrid();
    }

    // Step 2: Initialize the Grid
    private void initializeGrid() {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = random.nextInt(2); // 0 or 1
            }
        }
    }

    // Step 3: Count Alive Neighbors
    private int countAliveNeighbors(int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue; // Skip the cell itself
                int nx = (x + i + size) % size;
                int ny = (y + j + size) % size;
                count += grid[nx][ny];
            }
        }
        return count;
    }

    // Step 4: Apply Rules to Generate Next State
    public void nextGeneration() {
        int[][] newGrid = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int aliveNeighbors = countAliveNeighbors(i, j);

                if (grid[i][j] == 1) {
                    newGrid[i][j] = (aliveNeighbors == 2 || aliveNeighbors == 3) ? 1 : 0;
                } else {
                    newGrid[i][j] = (aliveNeighbors == 3) ? 1 : 0;
                }
            }
        }

        grid = newGrid;
    }

    // Step 5: Print the Grid
    public void printGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] == 1 ? "O" : ".");
            }
            System.out.println();
        }
    }

    // Step 6: Main Simulation Loop
    public static void main(String[] args) throws InterruptedException {

        int size = Integer.parseInt(args[0].split("=")[1]);
        int generations = Integer.parseInt(args[1].split("=")[1]);
        int sleep = Integer.parseInt(args[2].split("=")[1]);
        GameOfLife game = new GameOfLife(size);

        for (int i = 0; i < generations; i++) {
            game.printGrid();
            game.nextGeneration();
            System.out.println();
            Thread.sleep(sleep); // Pause for 200 milliseconds
        }
    }
}
