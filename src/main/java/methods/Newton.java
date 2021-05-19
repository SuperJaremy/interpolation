package methods;

import org.apache.commons.math3.util.CombinatoricsUtils;

import java.util.*;

public class Newton {
    public static double solve(double[] X, double[] Y, double x) {
        int previous = 0;
        for (int i = 0; i < X.length - 1; i++) {
            if (x >= X[i] && X[i + 1] >= x) {
                previous = i;
                break;
            }
        }
        if (x >= X[X.length - 1])
            previous = X.length - 1;
        Map<Integer, List<Double>> differencesByOrder = new HashMap<>();
        int order = 0;
        List<Double> y_i = new ArrayList<>();
        for (double v : Y) {
            y_i.add(v);
        }
        differencesByOrder.put(order, y_i);
        while (order < Y.length - 1) {
            order++;
            List<Double> deltaY = new ArrayList<>();
            List<Double> previousDeltaY = differencesByOrder.get(order - 1);
            for (int i = 0; i < previousDeltaY.size() - 1; i++) {
                deltaY.add(previousDeltaY.get(i + 1) - previousDeltaY.get(i));
            }
            differencesByOrder.put(order, deltaY);
        }
        if (previous < X.length / 2) {
            double t = (x - X[previous]) / (X[1] - X[0]);
            return interpolateForward(t, differencesByOrder, Y.length - previous - 1, previous);
        } else {
            int next = previous==X.length-1? previous : previous + 1;
            double t = (x - X[next]) / (X[1] - X[0]);
            return interpolateBackward(t, differencesByOrder, next);
        }
    }

    private static double interpolateForward(double t, Map<Integer, List<Double>> differencesByOrder, int order, int previous) {
        double value = differencesByOrder.get(0).get(previous);
        for (int i = 1; i <= order; i++) {
            value += (t / CombinatoricsUtils.factorial(i)) * differencesByOrder.get(i).get(previous);
            t *= (t - i);
        }
        return value;
    }

    private static double interpolateBackward(double t, Map<Integer, List<Double>> differencesByOrder, int order) {
        double value = differencesByOrder.get(0).get(order);
        for (int i = 1; i <= order; i++) {
            value += (t / CombinatoricsUtils.factorial(i)) * differencesByOrder.get(i).get(order - i);
            t *= (t + i);
        }
        return value;
    }
}
