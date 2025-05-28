package gol;

public class GolSkeletonB {
    public static void main(String[] args) throws Exception {
        // STEP 1. You need to get these values from args

        // w => (int) Width in characters (10, 20, 40, or 80 are the only valid values)
        // h => (int) Height in characters (10, 20, 40 are the only valid values)
        int w = 10;
        int h = 10;
        // g => (int) The max number of generations to run (>=0 are valid values)
        int g = 1000;
        //s => (int) The speed in milliseconds ([250,1000] are valid values)
        int s = 500;
        // p => (str) A representation of the population by cell sections [0|1]separated by character “#”
        String p = "1010101010#0101010101#1010101010#0101010101#1010101010#0101010101#1010101010#0101010101#1010101010#0101010101";

        // STEP 2. You need to validate each parameter

        // STEP 3. And define the goal settings with these input params:
        GolSettings goLSettings = new GolSettings(h, w, s, g);

        // STEP 4. You need to convert the initial input string p into a data structure for the grid of cells, on this example we use ints and a hard coded representation
        final int[][] grid = {
                {1, 0, 1, 0, 1, 0, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 1, 0, 1}, {1, 0, 1, 0, 1, 0, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 1, 0, 1}, {1, 0, 1, 0, 1, 0, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 1, 0, 1}};


        // STEP 5. We create a Gol generator that will process the grid
        final GolGenerator generator = new GolInverter(grid);

        // Will use a Terminal Console
        // STEP 6. You define the rendering process
        SwingRenderer.render(generator, new GolSettings(10, 10, 1000, 0));
    }
}

