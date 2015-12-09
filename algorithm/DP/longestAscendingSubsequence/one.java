/*
 * Longest ascending subsequence
 *
 * Given an array A[0] .... A[n-1] of integers, find out the length of the longest ascending subsequence.
 * Assumption: A is not null
 *
 * Examples:
 * input: A = { 5, 2, 6, 3, 4, 7, 5}
 * output: 4
 * Becase [2,3,4,5] is the longest ascending subsequence.
 *
 */




public class one {

    public int longest(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
    
        //m[i] represents the longest ascending subsequence from 0 to i including i.
        int[] m = new int[array.length];
        int global_max = Integer.MIN_VALUE;

        //base case
        m[0] = 1;
        global_max = 1;
        for (int i = 1; i < array.length; i++) {
            m[i] = 1;
            for (int j = 0; j < i; j++) {
                if (m[j] + 1 > m[i]) {
                    m[i] = m[j] + 1;
                }
            }
        
            if (m[i] > global_max) {
                global_max = m[i];
            }
        }
        return global_max;
    }

}









