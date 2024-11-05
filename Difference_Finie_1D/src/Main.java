import impl.Diff1D;
import util.ExpectedValueGenerator;
import util.Function;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Function<Double> f = (Double doubleValue) -> -2;
        Function<Double> U = (Double doubleValue) -> doubleValue*doubleValue;
        System.out.println((Diff1D.getError(U,U.evaluate(0.0), U.evaluate(1.0), f, 10)));
//        System.out.println(Arrays.toString(ExpectedValueGenerator.compute(U,10)));
    }

}