/* Subset I
 * Given a set of distinct integers, nums, return all possible subsets.
 *
 * Note: Elements in a subset must be in non-descending order.
 *       The solution set must not contain duplicate subsets.
 */

/*
 * SubsetI is very similar to Permutation I, 
 * we solve these kind of problem with DFS,
 * 1. create a void helper function, pass in the path arraylist, and nums integer array, (Subsets needs starting postion as well).
 * 2. go deep level by level, add position, 
 * 3. return result, if level == nums array length. (this means we've traversed all the possibilities.)
 */


public class Solution {

  public List<List<Integer>> subsets(int[] nums) {
      
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();

    subsetsHelper(result, list, nums, 0);
    return result;
  }

  private void subsetsHelper(List<List<Integer>> result, List<Integer> list, int[] nums, int position) {
    result.add(new ArrayList<Integer>(list));
    if (position == nums.length) return;

    for (int i = position; i < nums.length; i++) {
      list.add(nums[i]);
      subsetsHelper(result, list, nums, i+1);
      list.remove(list.size()-1);
    }
  }

}
