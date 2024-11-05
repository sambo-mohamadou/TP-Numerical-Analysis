package util;

public class Matrix {

    public static int n;
    public static int m;

    public static double h,k;

    public static void setSize(int n, int m){
         Matrix.n = n;
         Matrix.m = m;
         Matrix.h = 1.0/n;
         Matrix.k = 1.0/m;
    }

    public static double get(int i, int j){
         if (i == j){

             return 2 * (1/(h*h) + 1/(k*k));

         } else if ( j == i - 1) {
                    if (i % (n-1) == 0) {
                        return 0;
                    }else {
                        return  -1/(h*h);
                    }
         } else if (j == i + 1) {
                    if (i % (n-1) == n-2){
                        return 0;
                    }else {
                        return -1/(h*h);
                    }
         } else if (j == i - (n - 1)) {
                    if(i < n-1){
                        return 0;
                    }else {
                        return -1/(k*k);
                    }
         } else if (j == i + (n - 1)) {
                    if(i >= (m - 2)*(n - 1)){
                        return 0;
                    }else {
                        return -1/(k*k);
                    }
         }else {
             return 0;
         }
    }

}
