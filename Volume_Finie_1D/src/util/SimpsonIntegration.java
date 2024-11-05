package util;

public class SimpsonIntegration {

    public static double result(Function<Double> function, double lowerBound, double upperBound) {
        return (upperBound - lowerBound) * (function.evaluate(lowerBound) + 4*function.evaluate((lowerBound + upperBound)/2) + function.evaluate(upperBound))/6;
    }

}
