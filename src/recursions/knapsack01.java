package recursions;

import java.util.Scanner;

/**
 * Created by ArupPc on 19-05-2017.
 */
/*
* Time O(2^n)
* Space O(1)
* */
public class knapsack01 {
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

        System.out.println(knapsac(m,items,items.length));
    }

    private static int knapsac(int m, item[] items,int n) {

        //Base
        if(m == 0  || n == 0 )
            return 0;
        // if wt of nth item is mote than m
        if(items[n-1].getWt() > m)
            return knapsac(m,items,n-1);

        return Math.max(
                items[n-1].getProfit() + knapsac(m-items[n-1].getWt(),items,n-1),
                knapsac(m,items,n-1)

        );

    }

}
