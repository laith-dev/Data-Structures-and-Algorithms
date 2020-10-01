public class Miscellaneous {

    /**
     * Find the factorial of n.
     *
     * @param n is the number to find the factorial for.
     * @return the factorial of n.
     */
    public static int factorial(int n) {
        if (n < 0) {
            System.out.println("Factorial of negative numbers is not supported.");
            return -1;
        } else if (n == 1 || n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    /**
     * Find the n-th number in Fibonacci sequence.
     *
     * @param n-th number in Fibonacci sequence (zero index is taken into account).
     * @return n-th number in Fibonacci sequence.
     */
    public static int fibonacci(int n) {
        if (n < 0) {
            System.out.println("Fibonacci sequence starts from zero!");
            return -1;
        }

        if (n == 0) {
            return 0;
        }

        /* The first two numbers in Fibonacci sequence are 0 and 1. The other numbers can be
         * calculated as the sum of the previous two. */
        int[] fibs = new int[n + 1];
        fibs[0] = 0;
        fibs[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibs[i] = fibs[i - 1] + fibs[i - 2];
        }

        return fibs[n];
    }

}
