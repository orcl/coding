/* 
 * problem: search in a rotated sorted array
 *    Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *    (0 1 2 4 5 6 7) might become (4 5 6 7 0 1 2 ).
 *    you are given a target value to search. if found in the array return its index, otherwise return -1.
 *    you may assume no duplicate exists in the array.
 */

//recursive method.
public class Solution {

  public int search(int[] nums, int target) {
    return binarySearch(nums, 0, nums.length-1, target);
  }

  private int binarySearch(int[] nums, int left, int right, int target) {
  
    if (left > right) {
      return -1;
    }
    int mid = left + (right-left)/2;
    if (target == nums[mid]) {
      return mid;
    }
    if (nums[left] <= nums[mid]) {
      if (nums[left] <= target && target < nums[mid]) {
        return binarySearch(nums,left,mid-1,target);
      }else {
        return binarySearch(nums,mid+1, right, target);
      }
    }else {
      if (nums[mid] < target && target <= nums[right]) {
        return binarySearch(nums,mid+1,right,target);
      }else {
        return binarySearch(nums,left,mid-1,target);
      }
    }
  }
}




//iterative solution:

public class Solution {

  public int search(int[] nums, target) {
    
    int left = 0;
    int right = nums.length-1;
    while (left <= right) {
      int mid = left + (right-left)/2;
      if (target == nums[mid]) {
        return mid;
      }
      
      if (nums[left] <= nums[mid]) {
        //left side is sorted
        if (nums[left] <= target && target < nums[mid]) {
          //search left side
          right = mid - 1;
        }else {
          //search right side
          left = mid + 1;
        }
      }else {
        //right side is sorted
        if (nums[mid] < target && target <= nums[right]) {
          //search right side
          left = mid + 1;
        }else {
          //search left side
          right = mid - 1;
        }
      }
    }//end while

    return -1;
  }
}


