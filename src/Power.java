public class Power {

    public static double linearPowering(double base, int powerRaised) {

        double pow = 1;

        for (int i = 1; i <= Math.abs(powerRaised); i++)
            pow *= base;

        return (powerRaised >= 0) ? pow : 1/ pow;
    }

    public static double recursivePowering(double base, int powerRaised) {

        if (powerRaised == 0)
            return 1;
        else {

            double pow = base * recursivePowering(base, Math.abs(powerRaised) - 1);

            return (powerRaised >= 0) ? pow : 1 / pow;

        }
    }

    private boolean isEven(int x) {
        return (x % 2 == 0);
    }

}
