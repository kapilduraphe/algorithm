/**
 * Problem: Best Time to Buy and Sell Stock
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction
 * (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * 
 * Solution #1
 * This is equivalent to max subarray problem.
 * 1) generate an array of price difference;
 * 2) iterating through the array, calculating the local max ending with the current element;
 * 3) if adding the current element makes the local max less than zero, start from zero,
 *    which means re-start purchase from that price difference;
 * 4) check with each iteration if the local max is larger than the global max;
 *    if so, take the local max as the global max.
 *    
 * Solution #2
 * This method does not need to calcuate the price differences.
 * The highest profit is reached by currentPrcie - lowestPrice.
 * During the iteration, always update the lowestPrice when one is encountered,
 * calculate at the meantime whether prices[i] - lowestPrice is greater than the recorded
 * max profit.
 * 
 */
public class StockBuySell {
    // solution #1
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
        int currentMax = 0;  // max ending with the current element
        for (int i = 0; i < len-1; i++) {            
            currentMax = currentMax + priceDiff[i];
            if (currentMax < 0) {
                currentMax = 0;
            }
            if (currentMax > max) {
                max = currentMax;
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
        
        StockBuySell t = new StockBuySell();
        System.out.println(t.maxProfit(test2));
    }

}