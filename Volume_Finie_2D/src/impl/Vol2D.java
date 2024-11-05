package impl;

import util.ExpectedValueGenerator;
import util.Function;
import util.GaussSeidel;
import util.Matrix;

public class Vol2D {

    public static double[] solve(Function<Double> border, Function<Double> f, int n, int m){
        Matrix.setSize(n,m);
        return GaussSeidel.solve(generateConstVector(border,f,n,m));
    }

    private static double[] generateConstVector(Function<Double> border, Function<Double> f, int n, int m){
        double[] vec = new double[(n-1)*(m-1)];

        double x = 2.0/((n + 1) * n);
        double y = 2.0/((m + 1) * m);
        double h;
        double k;

        int ind;

        for (int i = 1; i < n ; i++) {
            for (int j = 1; j < m; j++) {
                ind = i-1 + (j-1)*(n-1);

                h = i*x + x/2;
                k = j*y + y/2;

                vec[ind] = f.evaluate((i*(i+1)/2)*x, (j*(j+1)/2)*x)*h*k;

                if (i==1){
                    if (j==1){
                        vec[ind] += (border.evaluate(0.0,j*y)) * 2*y /(i*x);
                    } else if (j == n-1) {
                        vec[ind] += (border.evaluate(0.0,j*y)) * (1.5*j*y + y) /(i*x);
                    }else{
                        vec[ind] += (border.evaluate(0.0,j*y)) * k /(i*x);
                    }
                }
                if (i==n-1){
                    if (j==1){
                        vec[ind] += (border.evaluate(0.0,j*y)) * 2*y /((i+1)*x);
                    } else if (j == n-1) {
                        vec[ind] += (border.evaluate(0.0,j*y)) * (1.5*j*y + y) /((i+1)*x);
                    }else{
                        vec[ind] += (border.evaluate(1.0,j*y)) * k /((i+1)*x);
                    }
                }
                if (j==1){
                    if (i==1){
                        vec[ind] += (border.evaluate(i*x,0.0)) * 2*x /(j*y);
                    } else if (i == n-1) {
                        vec[ind] += (border.evaluate(i*x,0.0)) * (1.5*i*x + x) /(j*y);
                    }else{
                        vec[ind] += (border.evaluate(i*x,0.0)) * h /(j*y);
                    }
                }
                if (j==n-1){
                    if (i==1){
                        vec[ind] += (border.evaluate(i*x,0.0)) * 2*x /((j+1)*y);
                    } else if (i == n-1) {
                        vec[ind] += (border.evaluate(i*x,0.0)) * (1.5*i*x + x) /((j+1)*y);
                    }else{
                        vec[ind] += (border.evaluate(i*x,1.0)) * h /((j+1)*y);
                    }
                }
            }
        }

        return vec;
    }

    public static double getError(Function<Double> U, Function<Double> border, Function<Double> f, int n, int m){
        return GaussSeidel.harmonicMean( GaussSeidel.sub( solve(border,f,n,m), ExpectedValueGenerator.compute(U,n,m)));
    }

}
