package io;

public class InputData {
    private final double[] X;
    private final double[] Y;
    private final double x;
    private final Methods method;

    InputData(double[] X, double[] Y, double x, Methods method){
        this.X = X;
        this.Y = Y;
        this.x = x;
        this.method = method;
    }

    public double[] getXs() {
        return X;
    }

    public double[] getY() {
        return Y;
    }

    public double getX() {
        return x;
    }

    public Methods getMethod() {
        return method;
    }
}
