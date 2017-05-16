package greedy;

import java.util.Scanner;

/**
 * Created by ArupPc on 16-05-2017.
 */
/* Kruskal visiting Edges
*5 nodes...
* Adjacency matrix
*
 *  _|0 1 2 3 4
*   0|0 4 2 0 5
    1|4 0 5 0 8
    2|2 5 0 6 0
    3|0 0 6 0 3
    4|5 8 0 3 0
* */
public class KruskalMST {

    public static Scanner scanner;
    public static final int MAX = 999;
    public static void print(int[][] mat){
        for(int i = 0; i < 5; i++)
        {
            for (int j=0; j<5; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        int[][] mat = new int[5][5];
        int[] parent = new int[5];
        int u = 0,v=0;
        int nOfEdges = 1;
        int total = 0;
        int min = MAX;
        for (int i = 0; i < 5; i++) {
            parent[i] = 0;
            for (int j = 0; j < 5; j++) {
                int x = scanner.nextInt();
                if(x == 0) // if 0 then there is no edge between the nodes hence init it as Max
                    x= 999;
                mat[i][j] = x;
            }
        }

        while(nOfEdges < 5){
            min = MAX;
            for(int i = 0; i< 5;i++){
                for(int j = 0; j< 5; j++){
                    if(mat[i][j] < min){
                        min = mat[i][j];
                        u = i;
                        v = j;
                    }
                }
            }

            while(parent[u] != 0){
                u = parent[u];
            }
            while(parent[v] != 0){
                v = parent[v];
            }
            if(v!=u){
                nOfEdges++;
                System.out.println("Edge found: " + u + "->" + v + ": weight=" + min);
                total+=min;
                parent[v] = u;

            }
            mat[u][v] = mat[v][u] = MAX; // undirected graphs



        }

        System.out.println("Minimum weight of MST is: " + total);
    }
}
