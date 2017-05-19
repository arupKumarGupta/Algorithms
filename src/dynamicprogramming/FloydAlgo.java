package dynamicprogramming;

import java.util.Arrays;

/**
 * Created by ArupPc on 19-05-2017.
 */
/*Assume the sides of a triangle in this algorithm
*
* let a,b,c are 3 vertices of a triangle
* floyd checks if ab + bc < ac
* then path is ab + bc
* */
public class FloydAlgo {

    static int[][] P;
    public static final int N = 4;

    public static void main(String[] args) {

        /*Put your own adj matrix below*/
        int[][] M = {

                {0,15,999,50},
                {40,999,15,999},
                {30,999,90,150},
                {125,999,65,60}

        };

        P = new int[N][N];
        System.out.println("Mat to find short path");
        print(M);
        System.out.println("Shortest Path Matrix");
        print(floydAlgo(M));
        System.out.println("Path Matrix");
        print(P);
    }

    private static int[][] floydAlgo(int[][] m) {
        for (int k = 0; k < N; k++) {

            for(int i = 0; i<N; i++){
                for (int j = 0; j < N; j++) {
                    if(m[i][k] + m[k][j] < m[i][j]){
                        m[i][j] = m[i][k] + m[k][j];
                        P[i][j] = k; // to keep track

                    }

                    //does'nt  keeps track
                    /*
                    * m[i][j] = Math.min(m[i][j],m[i][k]+m[k][j]);
                    * */
                }
            }
        }

        return m;
    }

    private static void print(int[][] m) {

        for (int[] x:
             m) {
            System.out.println(Arrays.toString(x));
        }

    }


}
