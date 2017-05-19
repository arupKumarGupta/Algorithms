package backtracking;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ArupPc on 19-05-2017.
 */
public class graphColoring {
    static int n=4,m=4;
    static int[][] g = new int[n][n];
   static int[] x = new int[n];

    public static void main(String[] args) {
        Scanner s  = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        for (int i = 0; i < m; i++) {
            x[i] = i+1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = s.nextInt();
            }
        }

        mColoring(0);
        if(any0(x))
            System.out.println("No Soln");
        else
        System.out.println(Arrays.toString(x));


    }

    private static boolean any0(int[] x) {
        for (int k:
             x) {
            if(k == 0)return true;
        }
        return false;
    }

    private static void print(int[][] board) {

        for (int[] x:board
                ) {
            System.out.println(Arrays.toString(x));
        }
    }
    private static boolean mColoring(int k) {

        for (int i = 1; i <= m; i++) {
            if(isSafe(k,i)){
                x[k] = i;

                if(k+1 < n)
                    mColoring(k+1);
                else {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isSafe(int v,int c)
    {
        for (int i = 0; i < n; i++)
            if (g[v][i] == 1 && c == x[i])
                return false;
        return true;
    }

}
