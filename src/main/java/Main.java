import io.ChartDrawer;
import io.ConsoleReader;
import io.InputData;
import methods.Lagrange;
import methods.Newton;

public class Main {
    public static void main(String[] args) {
//        double[] X = {0.1, 0.2, 0.3, 0.4, 0.5};
//        double[] Y = {1.25, 2.38, 3.79, 5.44, 7.14};
//        double x = 0.31;
//        double solution = Lagrange.solve(X,Y,x);
//        System.out.println(solution);
//        System.out.println(Newton.solve(X,Y,x));
        InputData data = ConsoleReader.read();
        double solution = data.getMethod().solve(data.getXs(), data.getY(), data.getX());
        System.out.printf("Значение в точке интерполяции %f: %f%n", data.getX(), solution);
        ChartDrawer chartDrawer = new ChartDrawer(data.getXs(), data.getY(), data.getMethod());
    }
}
