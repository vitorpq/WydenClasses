public class RecursionExample {

    public static void main(String[] args) {
        int number = 5;
        System.out.println("Factorial of " + number + " is: " + factorial(number));
    }

    public static int factorial(int n) {
        if (n <= 1) { // Base case
            return 1;
        }
        return n * factorial(n - 1);
    }
}

/*

5*factorial(4)*factorial(3)*factorial(2)*factorial(1)
 */