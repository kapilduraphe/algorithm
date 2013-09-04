/**
 * Problem: Best Time to Buy and Sell Stock III
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * You may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 * 
 * Solution:
 * For day i, keep track of the highest profit before this day and after this day.
 * maxProfit = profitBefore[i]                  + profitAfter[i]
 * maxProfit = (prices[i] - lowestHistoryPrice) + (highestFuturePrice - prices[i])
 * The first part can be calculated by scanning forward, and the latter part backward.
 * 
 */
public class StockDoubleBuySell {
    public int maxProfit(int[] prices) {
        
        int len = prices.length;
        if (len == 0 || len == 1) {
            return 0;
        }
        int maxProfit = 0;
        int[] profitBefore = new int[len];
        int[] profitAfter = new int[len];
        profitBefore[0] = 0;
        profitAfter[len-1] = 0;
        int lowestHistoryPrice = prices[0];
        int highestFuturePrice = prices[len-1];
        // calculate the highest profit before day i
        for (int i = 1; i < len; i++) {
            lowestHistoryPrice = Math.min(lowestHistoryPrice, prices[i]);
            // highest profit so far is reached either by a trade before (profitBefore[i-1])
            // or by the trade via selling the stock today (prices[i] - lowestHistoryPrice))
            profitBefore[i] = Math.max(profitBefore[i-1], prices[i] - lowestHistoryPrice);
        }
        
        // calculate the highest profit after day i
        for (int i = len - 2; i >= 0; i--) {
            highestFuturePrice = Math.max(highestFuturePrice, prices[i]);
            // future highest profit is reached either by a future trade (profitAfter[i+1])
            // or by the trade via buying the stock today (highestFuturePrice - prices[i])
            profitAfter[i] = Math.max(profitAfter[i+1], highestFuturePrice - prices[i]);
            // summing up the total profit
            maxProfit = Math.max(maxProfit, profitAfter[i] + profitBefore[i]);
        }        
        return maxProfit;
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