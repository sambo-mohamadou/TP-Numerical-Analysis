package test;

import impl.Diff2D;
import org.junit.Test;
import util.ExpectedValueGenerator;
import util.Function;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class TestFonctionnement {
    private final Function<Double> f = (Double x1, Double x2) -> 2 * x1*x1 + 4*x1;
//    private final Function<Double> U = (Double x1, Double x2) -> Math.sin(Math.PI*x1) * Math.sin(Math.PI*x2);
    private final Function<Double> BORDER =(Double x1, Double x2) -> 1 ;
@Test
    public void test(){
    System.out.println(Arrays.toString(Diff2D.solve(BORDER, f, 4, 4)));
//        assertArrayEquals(ExpectedValueGenerator.compute(U,3,3), Diff2D.solve(BORDER, f, 4,4), 0.1);
    }


}
