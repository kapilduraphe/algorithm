/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * 
 * Solution:
 * Same with StockBuySell, greedy algorithm:
 * 1) keep the sum of subarray ending at the current node in each iteration;
 * 2) if the current sum is smaller than 0, discard the previous sum, and
 *    re-calculate current by starting with the current node.
 * 3) at each iteration, check if the current sum is greater than the global
 *    sum.
 */
public class MaxSubarray {
    public int maxSubArray(int[] A) {
        int max = A[0];
        int current = A[0];
        int len = A.length;
        for (int i = 1; i < len; i++) {
            current = Math.max(current + A[i], A[i]);
            max = Math.max(max, current);
        }
        return max;
    }
}