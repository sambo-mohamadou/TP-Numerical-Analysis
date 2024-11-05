package util;

import java.util.Arrays;

public class GaussSeidel {

    private static final double PRECISION = 1e-6;

    public static double[] solve(double[][] matrix, double[] B) {
        int N = B.length;
        double[] X = new double[N]; // Initial solution vector

        while ( norm( residual(matrix, X, B)) < PRECISION){
            // Update solution vector
            for (int i = 0; i < N; i++) {
                double sum = B[i];
                for (int j = 0; j < N; j++) {
                    if (j != i) {
                        sum -= matrix[i][j] * X[j];
                    }
                }
                X[i] = sum / matrix[i][i];
            }

        }

        return X;
    }

    public static double[] solve(double[] B) {
        int N = B.length;
        double[] X = new double[N]; // Initial solution vector

        while ( norm( residual(X, B)) > PRECISION){
            // Update solution vector
            for (int i = 0; i < N; i++) {
                double sum = B[i];
                for (int j = 0; j < N; j++) {
                    if (j != i) {
                        sum -= MatrixRegularMesh.get(i,j) * X[j];
                    }
                }
                X[i] = sum / MatrixRegularMesh.get(i,i);
            }

        }

        return X;
    }

    public static double[] solveIrregular(double[] B) {
        int N = B.length;
        double[] X = new double[N]; // Initial solution vector
        MatrixIrregularMesh.setSize(N);

        while ( norm( residualIrregular(X, B)) > PRECISION){

            // Update solution vector
            for (int i = 0; i < N; i++) {
                double sum = B[i];
                for (int j = 0; j < N; j++) {
                    if (j != i) {
                        sum -= MatrixIrregularMesh.get(i,j) * X[j];
                    }
                }
                X[i] = sum / MatrixIrregularMesh.get(i,i);
            }

        }

        return X;
    }

    // Function to compute the residual vector AX - B
    public static double[] residual(double[][] matrix, double[] X, double[] B) {
        int N = B.length;
        double[] res = new double[N];
        for (int i = 0; i < N; i++) {
            res[i] = -B[i];
            for (int j = 0; j < N; j++) {
                res[i] += matrix[i][j] * X[j];
            }
        }
        return res;
    }

    public static double[] residual(double[] X, double[] B) {
        int N = B.length;
        double[] res = new double[N];
        for (int i = 0; i < N; i++) {
            res[i] = -B[i];
            for (int j = 0; j < N; j++) {
                res[i] += MatrixRegularMesh.get(i,j) * X[j];
            }
        }
        return res;
    }

    public static double[] residualIrregular(double[] X, double[] B) {
        int N = B.length;
        double[] res = new double[N];
        for (int i = 0; i < N; i++) {
            res[i] = -B[i];
            for (int j = 0; j < N; j++) {
                res[i] += MatrixIrregularMesh.get(i,j) * X[j];
            }
        }
        return res;
    }

    public static double[] sub(double[] X, double[] B) {
        int N = B.length;
        double[] sub = new double[N];
        for (int i = 0; i < N; i++) {
            sub[i] = X[i]-B[i];
        }
        return sub;
    }

    // Function to compute the norm of a vector
    public static double norm(double[] vec) {
        double sum = 0.0;
        for (double v : vec) {
            sum += v * v;
        }
        return Math.sqrt(sum);
    }

    public static double normInf(double[] vec) {
        double max = 0.0;
        for (double v : vec) {
            if(Math.abs(v) > max){
                max = Math.abs(v);
            }
        }
        return max;
    }

    public static double mean(double[] vec){
        double mean = 0.0;
        for (double v : vec) {
                mean += Math.abs(v);
        }
        return mean/ vec.length;
    }

    public static double harmonicMean(double[] vec){
        double mean = 0.0;
        for (double v : vec) {
            mean += 1.0/Math.abs(v);
        }
        return vec.length/mean;
    }

}
