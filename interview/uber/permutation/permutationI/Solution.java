/* Permutations I
 * given a collection of numbers, return all possible permutations.
 * for exmaple,
 * [1,2,3] have the following permutations.
 * [1,2,3], [1,3,2], [2,1,3], [3,1,2] and [3,2,1]
 * 
 * we solve this problem with dfs traversal, traverse all the possibilities.
 * subsets dfs traverse record every node.
 * permutation dfs traverse record leaf nodes.
 * that's the difference between subsets and permutations.
 *
 * also, the for loop is different, because, 
 * in permutations, we need to check if the element is already saved in our path list.
 *    for (int i = 0; i < nums.length; i++) {
 *        //get rid of the duplicated ones
 *        if (path.contains(nums[i]) {
 *          continue;
 *        }
 * int subsets, we need to track position, for loop starts with position,
 *    for (int i = position, i < nums.length; i++) {
 *
 *          empty
 *    1       2      3
 *  2  3    1  3    1 2
 * 3   2   3    1  2   1
 *
 * time complexity should be O(N!)
 */






public class Solution {

  public List<List<Integer>> permute(int[] nums) {
    if (nums == null) return null;
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();
    permuteHelper(result,path,nums);
    return result;
  }

  private void permuteHelper(List<List<Integer>>result, List<Integer>path, int[] nums) {
    
    if (path.size() == nums.length) {
      result.add(new ArrayList<Integer>(path));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      //get rid of the duplicated ones
      if (path.contains(nums[i])) {
        continue;
      }
      path.add(nums[i]);
      permuteHelper(result,path,nums);
      path.remove(path.size()-1);
    }
  }
}





