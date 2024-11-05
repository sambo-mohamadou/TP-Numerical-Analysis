package util;

public class MatrixRegularMesh {


    public static int get(int i, int j){

//        if(i == 0 || i == size - 1){
//            return i == j ? 3 : (Math.abs(i-j) <= 1 ? -1: 0);
//        }

        return i == j ? 2 : (Math.abs(i-j) <= 1 ? -1: 0) ;
    }

}
