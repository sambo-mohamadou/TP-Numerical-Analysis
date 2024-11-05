package test.irregularMesh;

import impl.Vol1D;
import org.junit.Test;
import util.ExpectedValueGenerator;
import util.Function;

import static org.junit.Assert.assertArrayEquals;

public class TestFonctionnement3 {

    private final double LOWERBOUND = 0;
    private final double UPPERBOUND = 1;

    private final double PRECISION = 1e-3;

    Function<Double> f = (Double doubleValue) -> 12*doubleValue*doubleValue - 2;

    Function<Double> U = (Double doubleValue) -> - doubleValue*doubleValue*doubleValue*doubleValue - doubleValue*doubleValue;

    @Test
    public void testPolynomialDegree2(){
        assertArrayEquals(ExpectedValueGenerator.compute(U,10), Vol1D.solveRegularMesh(U.evaluate(LOWERBOUND), U.evaluate(UPPERBOUND), f, 10), PRECISION);
    }

}
