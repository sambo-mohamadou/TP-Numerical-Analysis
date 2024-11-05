package impl;

import util.ExpectedValueGenerator;
import util.Function;
import util.GaussSeidel;
import util.SimpsonIntegration;

public class Vol1D {

    public static double[] solveRegularMesh(double a, double b, Function<Double> f, int n){
        return GaussSeidel.solve(generateConstVectorRegularMesh(a,b,f,n));
    }

    public static double[] solveIrregularMesh(double a, double b, Function<Double> f, int n){
        return GaussSeidel.solveIrregular(generateConstVectorIrregularMesh(a,b,f,n));
    }

    private static double[] generateConstVectorRegularMesh(double a, double b, Function<Double> f, int n){
        double[] vec = new double[n-1];
        double h = 1.0/n;

        vec[0] = SimpsonIntegration.result(f, h/2, 3*h/2) * (h) + a ;
        for (int i = 1; i < vec.length - 1; i++) {
            vec[i] = SimpsonIntegration.result(f, (i + 1.0/2) * h, (i + 3.0/2) * h) * (h) ;
        }
        vec[n-2] = SimpsonIntegration.result(f, (n- 3.0/2) * h, (n- 3.0/2) * h) * (h) + b ;
        return vec;
    }

    private static double[] generateConstVectorIrregularMesh(double a, double b, Function<Double> f, int n){
        double[] vec = new double[n-1];
        double x = 2.0/((n+ 1)*n);;

        vec[0] = SimpsonIntegration.result(f, x/2, 2 * x) + a / x ;
        for (int i = 1; i < vec.length - 1; i++) {
            vec[i] = SimpsonIntegration.result(f, ((i +1)*(i + 1))*x/2, ((i +2)*(i + 2))*x/2) ;
        }
        vec[n-2] = SimpsonIntegration.result(f, ((n-1)*(n-1))*x/2, (n*n)*x/2) + b / (n * x) ;
        return vec;
    }

    public static double getErrorRegular(Function<Double> U, double a, double b, Function<Double> f, int n){
        return GaussSeidel.harmonicMean( GaussSeidel.sub( solveRegularMesh(a,b,f,n), ExpectedValueGenerator.compute(U,n)));
    }

    public static double getErrorIrregular(Function<Double> U, double a, double b, Function<Double> f, int n){
        return GaussSeidel.harmonicMean( GaussSeidel.sub( solveIrregularMesh(a,b,f,n), ExpectedValueGenerator.compute(U,n)));
    }

}