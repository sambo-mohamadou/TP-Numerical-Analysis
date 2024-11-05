package test;

import impl.Vol2D;
import org.junit.Test;
import util.Function;

import java.util.HashMap;
import java.util.Map;

public class TestConvergenceSquare {

    private final int[] meshSizes = {3,5,8,10,12,14,18,21,23};

    private Map<Integer, Double> values;


    private final Function<Double> f = (Double x1, Double x2) -> 2 * Math.PI * Math.PI  * Math.sin(Math.PI*x1) * Math.sin(Math.PI*x2);
    private final Function<Double> U = (Double x1, Double x2) -> Math.sin(Math.PI*x1) * Math.sin(Math.PI*x2);
    private final Function<Double> BORDER = U;
    @Test
    public void generateResponseValues(){
        values = new HashMap<>();

        for (int size: meshSizes) {
            values.put(size, Vol2D.getError(U,BORDER, f, size, size));
        }

        for (int size:
                values.keySet().stream().sorted().toList()) {
            System.out.println(size +"\t"+values.get(size));
        }
    }
}
