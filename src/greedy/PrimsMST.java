package greedy;

import java.util.Scanner;

/**
 * Created by ArupPc on 16-05-2017.
 */

/* Prims visiting Nodes
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
public class PrimsMST {

    public static Scanner scan;


    public static void main(String[] args) {
        scan = new Scanner(System.in);
        int[][] mat = new int[5][5];
        int[] visited = new int[5];
        int min = Integer.MAX_VALUE;
        int u = 0;
        int v = 0;
        int total = 0;
        for (int i = 0; i < 5; i++) {
            visited[i] = 0;
            for (int j = 0; j < 5; j++) {
                int x = scan.nextInt();
                if(x == 0) // if 0 then there is no edge between the nodes hence init it as Max
                    x= 999;
                mat[i][j] = x;
            }
        }
        visited[0] = 1;
        //Algorithm
        for (int ctr = 0; ctr < 4; ctr++) {
            min = 999;
            for (int i = 0; i < 5; i++) {
                if (visited[i] == 1) {
                    for (int j = 0; j < 5; j++) {
                        if (visited[j] != 1) {
                            if (min > mat[i][j]) {
                                min = mat[i][j];
                                u = i;
                                v = j;
                            }
                        }
                    }
                }
            }
            visited[u] = visited[v] = 1;
            total += min;
            System.out.println("Edge found: " + u + "->" + v + ": weight=" + min);
        }

        System.out.println("Minimum weight of MST is: " + total);

    }
}
