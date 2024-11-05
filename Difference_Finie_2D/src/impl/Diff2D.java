package impl;

import util.ExpectedValueGenerator;
import util.Function;
import util.GaussSeidel;
import util.Matrix;

import java.util.Arrays;

public class Diff2D {

    public static double[] solve(Function<Double> border, Function<Double> f, int n, int m){
        Matrix.setSize(n,m);
        return GaussSeidel.solve(generateConstVector(border,f,n,m));
    }

    private static double[] generateConstVector(Function<Double> border, Function<Double> f, int n, int m){
        double[] vec = new double[(n-1)*(m-1)];
        double h = 1.0/n;
        double k = 1.0/m;
        int ind;

        for (int i = 1; i < n ; i++) {
            for (int j = 1; j < m; j++) {
                ind = i-1 + (j-1)*(n-1);
                vec[ind] = f.evaluate(i*h, j*k);
                if (i==1){
                    vec[ind] += border.evaluate(0.0,j*k)/(h*h);
                }
                if (i==n-1){
                    vec[ind] += border.evaluate(1.0,j*k)/(h*h);
                }
                if (j==1){
                    vec[ind] += border.evaluate(i*h,0.0)/(k*k);
                }
                if (j==n-1){
                    vec[ind] += border.evaluate(i*h,1.0)/(k*k);
                }
            }
        }

        return vec;
    }

    public static double getError(Function<Double> U, Function<Double> border, Function<Double> f, int n, int m){
        return GaussSeidel.harmonicMean( GaussSeidel.sub( solve(border,f,n,m), ExpectedValueGenerator.compute(U,n,m)));
    }

}
