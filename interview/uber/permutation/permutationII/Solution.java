public class Solution {

  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();
    boolean[] visited = new boolean[nums.length];
    Arrays.sort(nums);
    /* the reason we sort this array is because we want to group same value elements together.
     * then our below solution works, otherwise it doesn't work.
     */
    permuteHelper(result,path,nums,visited);
    return result;
  }

  private void permuteHelper(List<List<Integer>> result, List<Integer>path, int[] nums, boolean[] visited) {
    if (path.size() == nums.length) {
      result.add(new ArrayList<Integer>(path));
      return;
    }

    for (int i = 0; i < nums.length; i++){
      
      if (visited[i] == true || (i!= 0 && nums[i] == nums[i-1] && visited[i-1] == false) {
        continue;
      }

      for (int i = 0; i < nums.length; i++){
        
        if (visited[i] == true || (i!=0 && nums[i] == nums[i-1] && visited[i-1] == false)) {
          /*
           * here i!=0 && nums[i]==nums[i-1] && visited[i-1]
           * is because if number1 equals number2, by default, we use number1, abort number2
           * therefore number2 can't be used if the number1 haven't been used. (we need to abort number2).
           */
          continue;
        }

        visited[i] = true;
        path.add(nums[i]);
        permuteHelper(result,path,nums,visited);
        path.remove(path.size()-1);
        visited[i] = false;
      }
    }//end for loop
  }

}
