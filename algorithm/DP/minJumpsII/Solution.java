/*
 * Array Hopper II
 * Given an array A of non-negative integers, you are intially positioned at index 0 of the array. 
 * A[i] means the maximum jump distance from index i ( you can only jump towards the end of array). 
 * Determine the minimum number of jumps you need to reach the end of array.
 *
 * if you can not reach the end of the array, return -1.
 *
 * Assumptions:
 * the given array is not null and has length of at least 1.
 *
 * Examples:
 * {3,3,1,0,4} the minimum jumps needed is 2 (jump to index 1 then to the end of array).
 * {2,1,1,0,2}, you are not able to reach the end of array, return -1 in this case.
 */


public class Solution {

    public int minJump(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int[] m = new int[array.length];
        //m[i] means the minimum number of jumps from 0 to ith index, including ith index.
        //base case
        m[0] = 0;
        //induction rule
        boolean flag = false;
        for (int i = 1; i < array.length; i++) {
            m[i] = array.length;
            for (int j = 0; j < i; j++) {
                if (array[j] + j >= i) {
                    m[i] = Math.min(m[i], m[j]+1);
                }
            }
        }

        if (m[array.length-1] == array.length) {
            return -1;
        }
        return m[array.length-1];
    }

}








