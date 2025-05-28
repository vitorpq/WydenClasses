package gol;

import java.util.Random;

public class GolExampleC {

    static String createRandomGrid(int rows, int cols) {
        var random  = new Random();
        String grid = new String("");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid +=  random.nextBoolean()? "X": ".";
            }
            grid +=  "\n";
        };
        return grid;
    }

    public static void main(String[] args) throws Exception {

        final GolGenerator generator = new GolGenerator() {
            @Override
            public String getNextGenerationAsString(long generation) {
                if (generation == 0) {
                    return "";
                }
                else
                {
                    return createRandomGrid(30, 30);
                }
            }
        };

        // Will use a Terminal Console
        ConsoleRenderer.render(generator, new GolSettings(30, 30,1000, 0));
    }

}
