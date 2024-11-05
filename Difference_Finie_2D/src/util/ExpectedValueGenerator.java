package util;

public class ExpectedValueGenerator {

    public static double[] compute(Function<Double> f, int n, int m){

        double[] vec = new double[(n-1)*(m-1)];
        double h = 1.0/n;
        double k = 1.0/m;

        for (int i = 1; i < n ; i++) {
            for (int j = 1; j < m; j++) {
                vec[i-1 + (j-1)*(n-1)] = f.evaluate(i*h, j*k);
            }
        }

        return vec;
    }

}
