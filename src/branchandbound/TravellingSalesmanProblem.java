package branchandbound;

import java.util.Arrays;

/**
 * Created by ArupPc on 18-05-2017.
 */
public class TravellingSalesmanProblem {

    public static final int N = 4, MAX = 9999;

    public static void main(String[] args) {
        int[] finalPath = new int[N+1];
        boolean[] visited = new boolean[N];
        int finalCost = MAX;
        int[][] adj = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };


    }

    public static int[] getFinalPath(int[] currPath){

        int[] finalPath = new int[currPath.length+1];
        for (int i = 0; i < currPath.length; i++) {
            finalPath[i] = currPath[i];
        }
        finalPath[currPath.length] = finalPath[0];
        return finalPath;
    }

    public static int firstMin(int[][] adj, int vertex){

        int min = MAX;
        for(int k = 0; k < N;k++){
            if(adj[vertex][k] < min && vertex != k){
                min = adj[vertex][k];
            }
        }
        return min;
    }
    public static int secondMin(int[][] adj, int vertex){
        int first = MAX, second = MAX;
        for (int j=0; j<N; j++)
        {
            if (vertex == j)
                continue;

            if (adj[vertex][j] <= first)
            {
                second = first;
                first = adj[vertex][j];
            }
            else if (adj[vertex][j] <= second &&
                    adj[vertex][j] != first)
                second = adj[vertex][j];
        }
        return second;
    }


}
