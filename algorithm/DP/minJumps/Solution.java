/* Array Hopper I
 *
 * Given an array A of non-negative integers, you are initially positioned at index 0 of the array.
 * A[i] means the maximum jump distance from that position (you can only jump towards the end of the array).
 * determine if you are able to reach the last index.
 *
 * examples:
 * {1,3,2,0,3}, we are able to reach the end of array
 * {2,1,1,0,2}, we are not able to reach the end of array
 */


public class Solution {

    public boolean canJump(int[] array) {
    
        //m[i] means whether we can reach the ith position.
        boolean[] m = new boolean[array.length];

        m[0] = true;

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (m[j] && j+ array[j] >= i) {
                    m[i] = true;
                    break;
                }
            }
        }
    
        return m[array.length-1];    //return whether we can reach the last index.
    }

}






