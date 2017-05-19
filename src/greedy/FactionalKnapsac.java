package greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by ArupPc on 18-05-2017.
 */
public class FactionalKnapsac {


    static class Items implements Comparable<Items>{
        int p,w;
        double ratio;

        public int getP() {
            return p;
        }

        public int getW() {
            return w;
        }

        public double getRatio() {
            return ratio;
        }

        Items(int p, int w){
            this.p = p;
            this.w = w;
            ratio = (double)p/w;
        }

        @Override
        public int compareTo(Items o) {
            return new Double(this.ratio).compareTo(new Double(o.ratio));
        }
    }
    public static void print(Items[] it){
        for(Items i : it){
            System.out.print(i.p + " " );
        }
        System.out.println();
        for(Items i : it){
            System.out.print(i.w + " " );
        }
        System.out.println();
        for(Items i : it){
            System.out.print(i.ratio + " " );
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        double[] x = new double[n];
        Arrays.fill(x,0.0f);
        Items[] items = new Items[n];
        for(int i = 0; i < n; i++ ){
            int p,w;
            p = scan.nextInt();
            w = scan.nextInt();
            items[i] = new Items(p,w);
        }

        Arrays.sort(items, Collections.reverseOrder());
        int curWeight = 0;  // Current weight in knapsack
        double finalvalue = 0.0; // Result (value in Knapsack)

        // Looping through all Items
        for (int i = 0; i < n; i++)
        {
            // If adding Item won't overflow, add it completely
            if (curWeight + items[i].getW() <= m)
            {
                curWeight += items[i].getW();
                finalvalue += items[i].getP();
                x[i] = 1.0;
            }

            // If we can't add current Item, add fractional part of it
            else
            {
                int remain = m - curWeight;
                x[i] = ((double) remain / items[i].getW());
                finalvalue += items[i].getP() * x[i];
                break;
            }
        }
        print(items);
        System.out.println();
        System.out.println();
        System.out.println(Arrays.toString(x));
        System.out.println(finalvalue);
    }


}
