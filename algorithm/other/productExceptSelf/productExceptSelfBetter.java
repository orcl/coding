public class productExceptSelfBetter {

  public int[] productExceptSelf(int[] nums) {
    
    int[] result = new int[nums.length];

    int temp = 1;
    //in this loop, temp variable contains product of elements on left side excluding arr[i]
    for (int i = 0; i < nums.length; i++) {
      result[i] = temp;
      temp = temp * nums[i];
    }

    temp = 1;
    //in this loop, temp variable contains product of elements on right side excluding arr[i]
    for (int i = nums.length-1; i>=0; i--){
      result[i] = result[i] * temp;
      temp = temp * nums[i];
    }
    
    return result;
  }

}//end class productExceptSelfBetter

/* time complexity: O(n), space complexity: O(1)
 */
