package util;

public class Matrix {

    public static int get(int i, int j){
        return i == j ? 2 : (Math.abs(i-j) <= 1 ? -1: 0) ;
    }

}
