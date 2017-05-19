package dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ArupPc on 19-05-2017.
 */
public class knapsac01 {

    static class item{

        int profit;
        int wt;

        public item(int profit, int wt) {
            this.profit = profit;
            this.wt = wt;
        }

        public int getProfit() {
            return profit;
        }

        public int getWt() {
            return wt;
        }
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        item[] items = new item[n];
        for(int i = 0; i<n; i++){
            items[i] = new item(s.nextInt(),s.nextInt());

        }

        int i=0,w=0;
        int[][] K = new int[n+1][m+1];

        for ( i = 0; i <= n; i++) {
            for ( w = 0; w <= m ; w++) {
                if( i == 0 || w == 0)
                    K[i][w] = 0;
                else if(items[i-1].getWt() <= w)
                    K[i][w] = Math.max(items[i-1].getProfit() + K[i-1][w - items[i-1].getWt()],K[i-1][w]);
                else
                    K[i][w] = K[i-1][w];

            }
        }

        System.out.println(K[n][m]);
    }



}
