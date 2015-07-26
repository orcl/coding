//algorithm:
//1. construct a temporary array left[] such that left[i] contains product of all elements on left of arr[i] excluding arr[i]
//2. construct a temporary array right[] such that right[i] contains product of all elements on right of arr[i] excluding arr[i]
//3. to get result[], multiply left[] and right[].

public class productExceptSelf {

  public int[] productExceptSelf(int[] nums) {
    
    int result = new int[nums.length];
    if (nums.length == 0 || nums.length == 1) {
      return null;
    }

    int[] left  = new int[nums.length];
    int[] right = new int[nums.length];

    //leftmost element of left array is always 1
    left[0] = 1;
    //rightmost element of right array is always 1
    right[nums.length - 1] = 1;
    for (int i = 1; i < nums.length; i++) {
      left[i] = left[i-1] * nums[i-1];
      right[nums.length-1-i] = right[nums.length-i] * nums[nums.length -i];
    }
    for (int i = 0; i < nums.length; i++) {
      result[i] = left[i] * right[i];
    }
    
    return result;

  }
}//end class productExceptSelf
