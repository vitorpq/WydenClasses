import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/**
 * This class contains methods to generate and analyze Collatz sequences.
 */
public class Main {
    /**
     * Computes the length of the Collatz sequence for a given number.
     *
     * @param n the starting number
     * @return the length of the Collatz sequence
     */
    public static int collatzSequenceLength(int n) {
        int length = 1; // Start with length 1 to include the initial number

        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
            length++;
        }

        return length;
    }

    /**
     * Finds the number under a given limit that generates the longest Collatz sequence.
     *
     * @param limit the upper limit for the starting numbers
     */
    public static void findLongestCollatzSequence(int limit) {
        int numberWithLongestSequence = 0;
        int maxSteps = 0;
        int currentNumber;
        int currentLength;

        for (int i = 1; i < limit; i++) {
            currentNumber = i;
            currentLength = collatzSequenceLength(currentNumber);

            if (currentLength > maxSteps) {
                maxSteps = currentLength;
                numberWithLongestSequence = currentNumber;
            }
        }

        System.out.println("Limite: " + limit);
        System.out.println("Número: " + numberWithLongestSequence);
        System.out.println("Passos: " + (maxSteps - 1)); // Number of steps is the length of the sequence minus one

        // Print the sequence
        System.out.print("Sequencia: ");
        currentNumber = numberWithLongestSequence;
        while (currentNumber != 1) {
            System.out.print(currentNumber + " → ");
            if (currentNumber % 2 == 0) {
                currentNumber /= 2;
            } else {
                currentNumber = 3 * currentNumber + 1;
            }
        }
        System.out.println(1); // Print the last number
    }

    /**
     * Main method to run the Collatz sequence program.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the limit: ");
        int limit = scanner.nextInt();

        findLongestCollatzSequence(limit);
        scanner.close();
    }
}