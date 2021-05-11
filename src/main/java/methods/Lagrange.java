package methods;

public class Lagrange {

    public static double solve(double[] X, double[] Y, double x) {
        double sum = 0;
        for (int i = 0; i < X.length; i++) {
            sum += l_n(X, Y[i], x, i);
        }
        return sum;
    }

    private static double l_n(double[] X, double y, double x, int n) {
        double l_n = y;
        for (int i = 0; i < X.length; i++) {
            if (i != n)
                l_n *= (x - X[i]) / (X[n] - X[i]);
        }
        return l_n;
    }

}
