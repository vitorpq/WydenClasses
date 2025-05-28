package gol;
public class GolExampleA {
    public static void main(String[] args) throws Exception {

        final GolGenerator generator = new GolGenerator() {
            @Override
            public String getNextGenerationAsString(long generation) {
                // Just will switch
                if (generation % 2 == 0) {
                    return "XXX\nX.X\nXXX";
                }
                else
                {
                    return "...\n...\n...";
                }
            }
        };

        // Will use a Terminal Console
        ConsoleRenderer.render(generator, new GolSettings(3, 3,1000, 0));
    }
}
