package test;

import impl.Diff1D;
import org.junit.Test;
import util.ExpectedValueGenerator;
import util.Function;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class TestFonctionnement1 {

    private final double LOWERBOUND = 0;
    private final double UPPERBOUND = 1;

    private final double PRECISION = 1e-6;

    Function<Double> f = (Double doubleValue) -> 0;

    Function<Double> U = (Double doubleValue) -> 0;

    @Test
    public void testPolynomialDegree0(){
        double[] actuals =  Diff1D.solve(U.evaluate(LOWERBOUND), U.evaluate(UPPERBOUND), f, 10);
        System.out.println(Arrays.toString(actuals));
        assertArrayEquals(ExpectedValueGenerator.compute(U,10),actuals, PRECISION);
    }

}

