package util;

public class Matrix {
    public static int n;
    public static int m;

    public static double x,y;

    public static void setSize(int n, int m){
        Matrix.n = n;
        Matrix.m = m;
        Matrix.x = 2.0/((n + 1) * n);
        Matrix.y = 2.0/((m + 1) * m);
    }

    public static double get(int i, int j){
        double u = i % (n-1) + 1;
        double v = i % (m-1) + 1;
        double h = u*x + x/2;
        double k = v*y + y/2;

        if (i == j){

            return k/(u*x) + k/((u+1)*x) + h/(v*y) + h/((v+1)*y);

        } else if ( j == i - 1) {
            if (i % (n-1) == 0) {
                return 0;
            }else {
                return  -k/(u*x);
            }
        } else if (j == i + 1) {
            if (i % (n-1) == n-2){
                return 0;
            }else {
                return -k/((u+1)*x);
            }
        } else if (j == i - (n - 1)) {
            if(i < n-1){
                return 0;
            }else {
                return -h/(v*y);
            }
        } else if (j == i + (n - 1)) {
            if(i >= (m - 2)*(n - 1)){
                return 0;
            }else {
                return -h/((v+1)*y);
            }
        }else {
            return 0;
        }
    }

}
