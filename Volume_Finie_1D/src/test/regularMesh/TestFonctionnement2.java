package test.regularMesh;

import impl.Vol1D;
import org.junit.Test;
import util.ExpectedValueGenerator;
import util.Function;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class TestFonctionnement2 {

    private final double LOWERBOUND = 0;
    private final double UPPERBOUND = 1;

    private final double PRECISION = 1e-3;

    Function<Double> f = (Double doubleValue) -> 0;

    Function<Double> U = (Double doubleValue) -> doubleValue;

    @Test
    public void testPolynomialDegree1(){
        double[] actuals =  Vol1D.solveRegularMesh(U.evaluate(LOWERBOUND), U.evaluate(UPPERBOUND), f, 10);
        System.out.println(Arrays.toString(actuals));
        assertArrayEquals(ExpectedValueGenerator.compute(U,10), actuals, PRECISION);
    }
}
