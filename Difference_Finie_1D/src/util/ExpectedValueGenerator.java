package util;

public class ExpectedValueGenerator {

    public static double[] compute(Function<Double> f, int n){

        double[] vec = new double[n-1];
        double h = 1.0/n;

        for (int i = 0; i < vec.length; i++) {
            vec[i] = f.evaluate((i+1) * h );
        }

        return vec;
    }

}
