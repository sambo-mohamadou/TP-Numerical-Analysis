package test.irregularMesh;

import impl.Vol1D;
import org.junit.Test;
import util.ExpectedValueGenerator;
import util.Function;

import static org.junit.Assert.assertArrayEquals;

public class TestFonctionnement1 {

    private final double LOWERBOUND = 0;
    private final double UPPERBOUND = 1;

    private final double PRECISION = 1e-3;

    Function<Double> f = (Double doubleValue) -> 0;

    Function<Double> U = (Double doubleValue) -> 0;

    @Test
    public void testPolynomialDegree0(){
        assertArrayEquals(ExpectedValueGenerator.compute(U,10), Vol1D.solveIrregularMesh(U.evaluate(LOWERBOUND), U.evaluate(UPPERBOUND), f, 10), PRECISION);
    }

}

