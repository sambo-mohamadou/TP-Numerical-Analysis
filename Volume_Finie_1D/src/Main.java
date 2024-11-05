import impl.Vol1D;
import util.Function;
import util.ExpectedValueGenerator;
import util.MatrixIrregularMesh;
import util.SimpsonIntegration;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Function<Double> f = (Double doubleValue) -> 0;
        Function<Double> U = (Double doubleValue) -> doubleValue;
        System.out.println((Arrays.toString(Vol1D.solveIrregularMesh(U.evaluate(0.0), U.evaluate(1.0), f, 25))));
        System.out.println(Arrays.toString(ExpectedValueGenerator.compute(U,25)));
//        System.out.println(MatrixIrregularMesh.get(0,0) + "   " + MatrixIrregularMesh.get(2,1));
    }

}