public class Solution {
  
  public static void main(String[] args) {
    int[] input = new int[]{1,3,3,6,9,9,12,15};
    int target = 10;
    int k  = 5;

    kClosest(input, target, k);
  }//end main


  public static int[] kClosest(int[] array, int target, int k) {
    // Write your solution here
    if (array == null || array.length == 0)
      return array;
    
    int left = 0;
    int right = array.length -1;
    
    while (left < right-1) {
      int mid = left + (right-left)/2;
      if (array[mid] == target) {
        left = mid;
        break;
      }else if (array[mid] > target){
        right = mid;
      }
      else {
        left = mid;
      }
    }//end while
    
    
    int count = 0;   
    int[] result = new int[k];
    while (count < k) {
      //get the new one from either left or right side
      if ((Math.abs(array[left]-target) <= Math.abs(array[right]-target) ) && (left >= 0)) {
        result[count] = array[left];
        left--;
      }else if ((Math.abs(array[right]-target) < Math.abs(array[left]-target))  ){
          result[count] = array[right];
          right++;
      }
      count++;
      System.out.println(array[count]);
    }//end while loop
    
    return result;
  }

}
