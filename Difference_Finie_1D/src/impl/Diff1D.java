package impl;

import util.ExpectedValueGenerator;
import util.Function;
import util.GaussSeidel;

public class Diff1D {

    public static double[] solve(double a, double b, Function<Double> f, int n){
        return GaussSeidel.solve(generateConstVector(a,b,f,n));
    }

    private static double[] generateConstVector(double a, double b, Function<Double> f, int n){
        double[] vec = new double[n-1];
        double h = 1.0/n;

        vec[0] = f.evaluate(h) * (h*h) + a ;
        for (int i = 1; i < vec.length - 1; i++) {
            vec[i] = f.evaluate((i+1) * h ) * (h*h) ;
        }
        vec[n-2] = f.evaluate((n-1) * h ) * (h*h) + b ;

        return vec;
    }

    public static double getError(Function<Double> U, double a, double b, Function<Double> f, int n){
        return GaussSeidel.harmonicMean( GaussSeidel.sub( solve(a,b,f,n), ExpectedValueGenerator.compute(U,n)));
    }

}