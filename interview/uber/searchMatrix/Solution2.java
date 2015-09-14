/* problem: search a 2D matrix II
 * write an efficient algorithm that searches for a value in an mxn matrix. 
 * This matrix has the following properties.
 * Integers in each row are sorted in ascending from left to right.
 * integers in each column are sorted in ascending from top to bottom.
 *
 * hint: we can solve this problem diagonally.
 */

public class Solution {
  
  if (matrix == null || matrix.length == 0) {
    return false;
  }

  if (matrix[0] == null || matrix[0].length == 0) {
    return false;
  }

  //search diagonally
  int row = matrix.length-1;
  int col = matrix[0].length-1;
  int m = row;
  int n = 0;
  
  while (m>=0 && m <= row && n>=0 && n <= col) {
    int cur = matrix[m][n];
    if (cur == target) {
      return true;
    }else if (cur > target) {
      m--;
    }else [
      n++;
    }
  }//end while

  return false;

}//end class


