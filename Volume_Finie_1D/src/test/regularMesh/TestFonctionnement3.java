package test.regularMesh;

import impl.Vol1D;
import org.junit.Test;
import util.ExpectedValueGenerator;
import util.Function;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class TestFonctionnement3 {

    private final double LOWERBOUND = 0;
    private final double UPPERBOUND = 1;

    private final double PRECISION = 1e-1;

    Function<Double> f = (Double doubleValue) -> 12*doubleValue*doubleValue - 2;

    Function<Double> U = (Double doubleValue) -> - doubleValue*doubleValue*doubleValue*doubleValue + doubleValue*doubleValue;

    @Test
    public void testPolynomialDegree2(){
        double[] actuals =  Vol1D.solveRegularMesh(U.evaluate(LOWERBOUND), 0, f, 24);
        System.out.println(Arrays.toString(actuals));
        assertArrayEquals(ExpectedValueGenerator.compute(U,24), actuals, PRECISION);
    }

}
