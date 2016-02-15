/* Maximum subarray
 * Find the continuous subarray within an array (containing at least one number) which has the largest sum.
 * For example, give the array [-2,1,-3,4,-1,2,1,-5,4].
 * the continuous subarray [4,-1,2,1] has the largest sum = 6.
 */

public class Solution {

    public int maxSubArray(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return 0;
        }
    
        //use dp
        int global_max = nums[0];
        //m[i] represents the maximum subarray sum from any position before i to ith position,(ending at ith position!!)
        //base case:
        m[0] = nums[0];

        for (int i=1; i < nums.length; i++) {
            if (m[i-1] <= 0) {
                m[i] = nums[i];
            }else {
                m[i] = m[i-1] + nums[i];
            }

            if (global_max < m[i]) {
                global_max = m[i];
            }
        }

        return global_max;
    
    }//end maxSubArray



    public int largestSum(int[] array) {
    
        if (array == null || array.length == 0) {
            return 0;
        }

        int global_max = array[0];
        int cur_max    = array[0];

        for (int i = 1; i < array.length; i++) {
            cur_max = Math.max(cur_max + array[i], array[i]);
            global_max = Math.max(global_max, cur_max);
        }//end for loop
    
        return global_max;
    }//end largestSum




}//end class Solution





