/*
 * Given an unsorted array, find the length of the longest subarray in which the numbers are in ascending order.
 * For example, if the input array is { 7, 2, 3, 1, 5, 8, 9, 6}, the subarray with the most numbers in ascending order is {1,5,8,9} and the expected value is 4. 
 *
 * sub-array: contiguous sub-section of an array
 * sub-sequence: can be non-contiguous sub section
 *
 * Solution: 
 * input = 7, 2, 3, 1, 5, 8, 9, 6
 * M[i] = {1, 1, 2, 1, 2, 3, 4, 1}
 * scan one direction, look back only 1 element
 * global_max = 4
 *
 * (1) base case: only 1 element
 * (2) induction rule:
 *      M[i] represents from left to right hand side, starting from index = 0, what is the length of the longest subarray ended at element i, including the i-th element.
 *      M[i] = M[i-1] + 1      if (input[i] > input[i-1])
 *              1               otherwise
 *
 */



public class Solution {
    
    public int longest(int[] array) {
        //Assumptions: the given array is not null.
        if (array.length == 0) {
            return 0;
        }

        int result = 1;
        int cur    = 1;
        for (int i = 1; i < array.length; i++) {
            //if array[i] > array[i-1], the current ascending subarray can add one element.
            if (array[i] > array[i-1]) {
                cur++;
                result = Math.max(result,cur);
            }else {
                //otherwise, we need to start a new ascending subarray
                cur = 1;
            }
        }
        return result;

    }//end longest

}//end class Solution



