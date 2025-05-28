public class textoSplit {
    public static void main(String[] args) {
        String[] words = args[0].split("\\s+");

        for(String word: words) {
            System.out.println(word);
        }
    }
}
