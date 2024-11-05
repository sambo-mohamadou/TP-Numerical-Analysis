package test.regularMesh;

import impl.Vol1D;
import org.junit.Test;
import util.Function;

import java.util.HashMap;
import java.util.Map;

public class TestConvergence1 {

    private final double LOWERBOUND = 0;
    private final double UPPERBOUND = 1;
    private final int[] meshSizes = {2,4,8,10,12,14,18,20,22,24,28,30,35,40,45,50,60,70,100,150};

    private Map<Integer, Double> values;
    private final Function<Double> f = Math::cos;
    private final Function<Double> U = Math::cos;

    @Test
    public void generateResponseValues(){
       values = new HashMap<>();

        for (int size: meshSizes) {
            values.put(size, Vol1D.getErrorRegular(U,U.evaluate(LOWERBOUND), U.evaluate(UPPERBOUND), f, size));
        }

        for (int size:
                values.keySet().stream().sorted().toList()) {
            System.out.println(size +"\t"+values.get(size));
        }
    }
}
