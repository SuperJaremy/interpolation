package io;

import methods.Lagrange;
import methods.Newton;

public enum Methods {
    LAGRANGE("Многочлен Лагранжа", (Lagrange::solve)),
    NEWTON("Многочлен Ньютона",(Newton::solve));

    private final String name;

    private final DataToMethod solver;

    Methods(String name, DataToMethod solver) {
        this.name = name;
        this.solver = solver;
    }

    @Override
    public String toString() {
        return name;
    }

    public double solve(double[] X, double[] Y, double x) {
        return solver.apply(X, Y, x);
    }

    private interface DataToMethod {
        double apply(double[] X, double[] Y, double x);
    }
}
