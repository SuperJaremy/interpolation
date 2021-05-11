import methods.Lagrange;

public class Main {
    public static void main(String[] args){
        double[] X = {0.1, 0.2, 0.3, 0.4, 0.5};
        double[] Y = {1.25, 2.38, 3.79, 5.44, 7.14};
        double solution = Lagrange.solve(X, Y, 0.35);
        System.out.println(solution);
    }
}
