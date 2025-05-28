package gol;

public class GolInverter implements GolGenerator{

    private int[][] grid;

    public GolInverter(int[][] grid) {
        this.grid = grid;
    }

    // Invert 1->0 and 0->1 in a Matrix
    private void invertValues(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = matrix[i][j] == 1 ? 0 : 1;
            }
        }
    }

    // Converts a matrix to a flat String
    // [0,0,0][1,1,1][0,1,0] => "...\nXXX\n.X."
    private String toGridString(int[][] matrix) {
        String grid = new String("");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                grid += (matrix[i][j] == 1 ? "X" : ".");
            }
            grid += "\n";
        }
        return grid;
    }

    @Override
    public String getNextGenerationAsString(long generation) {
        if (generation != 0) {
            // STEP 7. We calculate the next generation
            invertValues(grid);
        }
        // STEP 8. We return the next generation (as a String)
        return toGridString(grid);
    }
}
