/**
 * Problem: Best Time to Buy and Sell Stock III
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * You may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 * 
 * Solution: 
 * 
 */
public class StockDoubleBuySell {
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
        
        int maxFirst = 0;
        int maxSecond = 0;
        int currentMax = 0;
        for (int i = 0; i < len-1; i++) {
            if (priceDiff[i] >= 0) {
                currentMax = currentMax + priceDiff[i];
            } else {
                if (currentMax > maxFirst) {
                    maxSecond = maxFirst;
                    maxFirst = currentMax;
                    System.out.printf("maxFirst: %d, maxSecond: %d\n", maxFirst, maxSecond);
                } else if (currentMax > maxSecond) {
                    maxSecond = currentMax;
                    System.out.printf("maxSecond: %d\n", maxSecond);
                }
                currentMax = 0;
            }
        }
        // 
        if (currentMax >= maxFirst) {
            maxSecond = maxFirst;
            maxFirst = currentMax;
            System.out.printf("maxFirst: %d, maxSecond: %d\n", maxFirst, maxSecond);
        } else if (currentMax > maxSecond) {
            maxSecond = currentMax;
            System.out.printf("maxSecond: %d\n", maxSecond);
        }
        return maxFirst + maxSecond;
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
        
        int[] test4 = new int[5];
        test4[0] = 2;
        test4[1] = 1;
        test4[2] = 2;
        test4[3] = 0;
        test4[4] = 1;
        
        int[] test5 = new int[10];
        test5[0] = 1;
        test5[1] = 2;
        test5[2] = 4;
        test5[3] = 2;
        test5[4] = 5;
        test5[5] = 7;
        test5[6] = 2;
        test5[7] = 4;
        test5[8] = 9;
        test5[9] = 0;
        
        StockDoubleBuySell t = new StockDoubleBuySell();
        System.out.println("test starts:");
        System.out.printf("test []: %d\n", t.maxProfit(test0));
        System.out.printf("test [0]: %d\n", t.maxProfit(test1));
        System.out.printf("test [0, 1, 2, 3, 4]: %d\n", t.maxProfit(test2));
        System.out.printf("test [0, 1, 0, 2, 0, 3, 0, 4]: %d\n", t.maxProfit(test3));
        System.out.printf("test [2, 1, 2, 0, 1]: %d\n", t.maxProfit(test4));
        System.out.printf("test [1, 2, 4, 2, 5, 7, 2, 4, 9, 0]: %d\n", t.maxProfit(test5));
        System.out.println();
    }

}