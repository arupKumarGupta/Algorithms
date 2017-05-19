package backtracking;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ArupPc on 19-05-2017.
 */
public class NQueenProblem {

    static int N=4 ;
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);


        N = s.nextInt();
        int[][] board = new int[N][N];
        if(!solve(board,0)){
            System.out.println("Solution Not Found");
        }
        print(board);

    }

    private static void print(int[][] board) {

        for (int[] x:board
             ) {
            System.out.println(Arrays.toString(x));
        }
    }

    private static boolean solve(int[][] board, int col) {

        if(col >= N)
            return true;
        for (int i = 0; i < N; i++) {
            if(safe(board,i,col)){
                board[i][col] = 1;
                if(solve(board,col+1))
                    return true;
                board[i][col] = 0; //backtracking
            }
        }


        return false;
    }

    private static boolean safe(int[][] board, int row, int col) {


        int i,j;
        for ( i = 0; i < col; i++) {
            if(board[row][i] == 1)
                return false;
            
        }

        for (i=row, j = col; i >=0 && j >=0 ; i--,j--){
            if(board[i][j] == 1)
                return false;
        }
        for (i=row, j = col; j >=0 && i  < N ; i++,j--){
            if(board[i][j] == 1)
                return false;
        }

        return true;

    }


}


