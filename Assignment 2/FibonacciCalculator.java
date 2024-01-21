public class FibonacciCalculator {

    public static void main(String[] args) {
        int n = 10;
        int nthFibonacci = fibonacci(n);
        System.out.println("The " + n + "th term of the Fibonacci sequence is " + nthFibonacci + ".");
    }

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
