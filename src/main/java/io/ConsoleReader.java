package io;

import java.util.Scanner;

public class ConsoleReader {

    public static InputData read(){
        Scanner input = new Scanner(System.in);
        System.out.println("Введите количество пар (x,y)");
        int n = input.nextInt();
        double[] X = new double[n];
        double[] Y = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите x y");
            X[i] = input.nextDouble();
            Y[i] = input.nextDouble();
        }
        System.out.println("Введите точку интерполяции");
        double x = input.nextDouble();
        System.out.println("Выберите многочлен для решения");
        for (int i = 0; i < Methods.values().length; i++) {
            System.out.printf("%d. %s%n",i+1, Methods.values()[i]);
        }
        n = input.nextInt()-1;
        Methods method = Methods.values()[n];
        return new InputData(X, Y, x, method);
    }
}
