public class Power {

    public static double linearPowering(double base, int power) {
        double pow = 1;

        for (int i = 1; i <= Math.abs(power); i++) {
            pow *= base;
        }

        return (power >= 0) ? pow : 1 / pow;
    }

    /**
     * Find the power of n based on power.
     *
     * @param n     the base number of powering.
     * @param power the power that raised to n. Positive or negative.
     * @return n to the power 'power'.
     */
    public static double recursivePowering(double n, int power) {

        if (power == 0)
            return 1;
        else {
            double pow = n * recursivePowering(n, Math.abs(power) - 1);
            return (power >= 0) ? pow : 1 / pow;
        }
    }

    private boolean isEven(int x) {
        return (x % 2 == 0);
    }

}
