/**
* Follow up for "Remove Duplicates":
* What if duplicates are allowed at most twice?
*
* For example,
* Given sorted array A = [1,1,1,2,2,3],
*
* Your function should return length = 5, and A is now [1,1,2,2,3].
* 
* Solution:
* 1)
* Use two pointer, before and after, during the iteration.
* A[before] is the current unprocessed elements,
* A[after] is the last processed element.
* 2)
* Use a counter, count, to record how many duplicates there are.
* Initially, count = 1. When there is a duplicate, set it to 0.
* If a second duplicate exists, count remains 0.
* Reset count to 1 for every new int encountered.
* 3)
* If A[before] != A[after], A[before] is a new int.
* Set it as the next processed element A[after+1], increase after by 1.
* If A[before] is a duplicate for the first time,
* do the same, and set count to 0.
* If A[before] is a second duplicate, just go to the next A[before].
* 
*/
public class RmDupFromSortedArrayII {
    public int removeDuplicates(int[] A) {        
        int count = 1;
        if (A.length <= 2) {
            return A.length;
        }
        int after = 0;
        // A[after] is the last validated element
        // A[before] is the current element to be validated
        for (int before = 1; before < A.length; before++) {
            if (A[before] != A[after]) {
                A[after+1] = A[before];
                count = 1;
                after = after + 1;
            } else if (count == 1) {
                A[after+1] = A[before];
                count = 0;
                after = after + 1;
            }
        }
        // after is 0-based, add 1.
        return after + 1;
    }
}