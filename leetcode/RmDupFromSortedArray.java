/*
* Given a sorted array, remove the duplicates in place such that
* each element appear only once and return the new length.
* 
* Do not allocate extra space for another array,
* you must do this in place with constant memory.
*
* For example,
* Given input array A = [1,1,2],
* Your function should return length = 2, and A is now [1,2].
* 
* * Solution:
* 1)
* Use two pointer, before and after, during the iteration.
* A[before] is the current unprocessed elements,
* A[after] is the last processed element.
* 
* 2)
* If A[before] != A[after], A[before] is a new int.
* Set it as the next processed element A[after+1], increase after by 1.
* If A[before] is a duplicate, just go to the next A[before].
*/
public class RmDupFromSortedArray {
    public int removeDuplicates(int[] A) {        
        if (A.length <= 1) {
            return A.length; 
        }
        int after = 0;
        // A[after] is the last processed element that is valid
        // A[before] is the current element to be validated for duplication
        for (int before = 1; before < A.length; before++) {
            if (A[before] != A[after]) {
                A[after+1] = A[before];
                after = after + 1;
            }
        }
        // after is 0-based, add 1.
        return after + 1;
    }
}