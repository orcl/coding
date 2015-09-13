/* 
 * given an array of non-negative integers, you are initally positioned at the first index of the array.
 * each element in the array represents your maximum jump length at that position.
 * Delete if you are able to reach the last index.
 *
 *
 * Solution:
 *   the idea is that local maximal and global maximal.
 *   we keep track the current max index that we can reach with (max variable). max = Math.max(global,local).
 *   we keep track of the local optinal which is local = A[i] + i,
 */


public class Solution {
  public boolean canJump(int[] nums) {
    if (nums == null || nums.length == 0) {
      return true;
    }
    int max = 0;
    for (int i = 0; i< nums.length; i++) {
      if (i>max || i >= (nums.length-1)) {
        break;
      }
      max = Math.max(max, i+nums[i]);
    }

    return max>=nums.length-1;
  }
}//end Solution
