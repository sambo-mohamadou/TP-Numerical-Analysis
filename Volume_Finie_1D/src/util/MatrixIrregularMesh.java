package util;

public class MatrixIrregularMesh {

    private static int size;
    private static double x;

    public static void setSize(int size) {
        MatrixIrregularMesh.size = size;
        MatrixIrregularMesh.x = 2.0/((size + 1)*(size + 2));
    }

    public static double get(int i, int j){

        return i == j ? (1/((i + 2) *x) + 1/((i + 1)  * x)) : (Math.abs(i-j) <= 1 ? (i > j ? -1/((i + 1) * x) : -1/((i + 2) *x)) : 0) ;
    }

}
