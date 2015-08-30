public class Solution {

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    if (nums == null) return null;

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();
    Arrays.sort(nums);
    subsetsHelper(result,path,nums,0);
    return result;
  }

  private void subsetsHelper(List<List<Integer>>result, List<Integer>path, int[] nums, int position) {
    result.add(new ArrayList<Integer>(path));

    for (int i = position; i < nums.length; i++) {
      if (i != position && nums[i] == nums[i-1]) {
        /*
         * this is horizontally check, which mean number1 is used, number2 equals number1, number2 can't be used again.
         * for example,
         *              empty set
         *        number1     number2 (don't use, because it's the same thing as number1, and leads to duplicate)
         * vertical duplicates are okay in this case.
         */
        continue;
      }
      path.add(nums[i]);
      subsetsHelper(result,path,nums,i+1);
      path.remove(path.size()-1);
    }
  }

}//end class Solution



