public class FibonacciCalculator {

    public static void main(String[] args) {
        int n = 10;
        int nthFibonacci = fibonacci(n);
        System.out.println("The " + n + "th term of the Fibonacci sequence is " + nthFibonacci + ".");
    }

    /**
     * Calculates the nth term in the Fibonacci sequence iteratively.
     * The Fibonacci sequence is a series of numbers where each number
     * is the sum of the two prior ones.
     *
     * @param n The position in the Fibonacci sequence to calculate.
     *          The first position in the sequence is 0.
     * @return The nth term in the Fibonacci sequence.
     */
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
