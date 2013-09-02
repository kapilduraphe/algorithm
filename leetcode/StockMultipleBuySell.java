/**
 * Problem: Best Time to Buy and Sell Stock II
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times). However, you may not engage
 * in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * 
 * Solution:
 * Generate the price difference.
 * Whenever the difference is positive, add it to the max.
 * 
 */
public class StockMultipleBuySell {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0 || len == 1) {return 0;}
        // create an array of price differences
        // prices[0..len-1]
        // priceDiff[0..len-2]
        int[] priceDiff = new int[len-1];
        for (int i = 0; i < len-1; i++) {
            priceDiff[i] = prices[i+1] - prices[i];            
        }
        
        int max = 0;  // global max
        for (int i = 0; i < len-1; i++) {
            if (priceDiff[i] > 0) {
                max = max + priceDiff[i];
            }
            
        }

        return max;
    }
    
    public static void main() {
        int[] test0 = new int[0];
        int[] test1 = new int[1];
        test1[0] = 0;
        int[] test2 = new int[5];        
        for (int i = 0; i < test2.length; i++){
            test2[i] = i;
        }
        int[] test3 = new int[9];
        test3[0] = 0;
        test3[1] = 1;
        test3[2] = 0;
        test3[3] = 2;
        test3[4] = 0;
        test3[5] = 3;
        test3[6] = 0;
        test3[7] = 4;
        
        StockMultipleBuySell t = new StockMultipleBuySell();
        System.out.printf("test []: %d\n", t.maxProfit(test0));
        System.out.printf("test [0]: %d\n", t.maxProfit(test1));
        System.out.printf("test [0, 1, 2, 3, 4]: %d\n", t.maxProfit(test2));
        System.out.printf("test [0, 1, 0, 2, 0, 3, 0, 4]: %d\n", t.maxProfit(test3));
    }

}