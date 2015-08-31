/*
 * Problem: 4Sum
 *    Given an array S of n integers, are there elements a,b,c,d in S such that a+b+c+d = target? 
 *    Find all unique quadruplets in the array which gives the sum of target.
 *    Note:
 *      elements in a quadruplet (a,b,c,d) must be in non-descending order (i. a <= b <= c <= d)
 *      the solution set must not contain duplicate quadruplets.
 *
 * Solution: we solve this problem in the same way as what we do in 3Sum,
 *           the only difference is that we add another layer for loop,
 *           in 3 sum, we have nums[i] + nums[left] + nums[right]
 *           in 4 sum, we have nums[i] + nums[j] + nums[left] + nums[right] instead. that's it.
 *
 *           determine i, j , moving pointer left right, they are all in different indexes.
 *
 *
 */


public class Solution {

  public List<List<Integer>> fourSum(int[] nums, int target) {
  
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (nums.length < 4) return result;
    Arrays.sort(nums);

    for (int i = 0; i < nums.length-3; i++) {
      if (i > 0 && nums[i] == nums[i-1]) continue;
      for (int j = i+1; j< nums.length-2; j++) {
        if (j>i+1 && nums[j] == nums[j-1]) continue;
        int low = j+1;
        int high = nums.length - 1;
        while (low <high) {
          int sum = nums[i] + nums[j] + nums[low] + nums[high];
          if (sum == target) {
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(nums[i]);
            tmp.add(nums[j]);
            tmp.add(nums[low]);
            tmp.add(nums[high]);
            result.add(tmp);

            while (low<high && nums[low] == nums[low+1]) low++;
            while (low<high && nums[high] == nums[high-1]) high--;
            low++;
            high--;
          }else if (sum < target) {
            low++;
          }else {
            high--;
          }
        }
      }
    }
    return result;
  }//end forSum
}//end class Solution


