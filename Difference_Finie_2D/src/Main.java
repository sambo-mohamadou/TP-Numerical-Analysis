import impl.Diff2D;
import util.ExpectedValueGenerator;
import util.Function;
import util.Matrix;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Function<Double> f = (Double x1, Double x2) -> 2 * Math.PI * Math.PI  * Math.sin(Math.PI*x1) * Math.sin(Math.PI*x2);
        Function<Double> U = (Double x1, Double x2) -> Math.sin(Math.PI*x1) * Math.sin(Math.PI*x2);
        System.out.println((Arrays.toString(Diff2D.solve(U, f, 3,3))));
        System.out.println();
        System.out.println((Arrays.toString(Diff2D.solve(U, f, 3,5))));
    }
}