/*
 * given an unsorted integer array, find the subarray that has the greatest sum.
 * return the sum.
 *
 * Assumptions:
 *  the given array is not null and has length of at least 1.
 *
 * Examples:
 *  {2, -1, 4, -2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5
 *  {-2, -1, -3}, the largest subarray sum is -1.
 *
 */

//idea: linear scan, look back at i-1, because subarray.
//
public class Solution {

    public int largestSum(int[] array) {
        //write your solution here.
        if (array == null || array.length == 0) {
            return 0;   
        }

        int global_max = 0;
        int[] m = new int[array.length];
        global_max = array[0];
        m[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            if (m[i-1]>0) {
                m[i] = m[i-1] + array[i];
            }else {
                m[i] = array[i];
            }
            if (m[i] > global_max) {
                global_max = m[i];
            }
        }

        return global_max;
    }

}




