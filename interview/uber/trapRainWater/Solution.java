/*
 * problem: Trapping rain water
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 * hint: an O(n) solution is to consider each bar at a time.
 * for each bar, the water itself can trap depends on the max height on its left and right,
 * if current bar is of height2, the max height on its left is 4, max height on its right is 3.
 * then water can be trapped in this bar is min(4,3)-2=1.
 * thus, we can scan the whole map twice to get the max height on right and left, respectively.
 * finally we can again to get the water trapped of all.
 *
 */

public class Solution {

  public int trapRainWater(int[] heights) {
    int n = heights.length;
    
    if (n < 2) {
      return 0;
    }

    int[] left  = new int[n];
    int[] right = new int[n];

    int water = 0;

    left[0] = 0;
    for (int i = 1; i < n; i++) {
      left[i] = Math.max(left[i-1], heights[i-1]);
    }

    right[n-1] = 0;
    for (int i = n-1; i>=0;i--) {
      right[i] = Math.max(right[i+1],heights[i+1]);
    }

    for (int i = 0; i < n; i++) {
      if (Math.min(left[i],right[i])-heights[i] >0) {
        water += Math.min(left[i],right[i])-heights[i];
      }
    }
    return water;
  }//end trapRainWater
}//end class Solution




