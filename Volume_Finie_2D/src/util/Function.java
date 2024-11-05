package util;

@FunctionalInterface
public interface Function<T> {

    double evaluate(T t1, T t2);

}