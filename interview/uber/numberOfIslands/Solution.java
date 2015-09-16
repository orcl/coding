/* problem: Number of Islands
 * Given a boolean 2D matrix, find the number of islands.
 */

public class Solution {

  public int numIslands(boolean[][] grid) {
    //write your code here.
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int count = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        count++;
        search(grid,i,j);
      }
    }


  }//end numIslands

  private void search(boolean[][] grid, int i, int j) {
    //validity checking
    if (i < 0 || j < 0 || i > grid.length-1 || j > grid[0].length-1) {
      return;
    }

    //if current cell is water or visited
    if (grid[i][j] != true) {
      return;
    }

    //set visited cell to '0'
    grid[i][j] = false;

    //search all four directions
    search(grid,i-1,j);
    search(grid,i+1,j);
    search(grid,i,j-1);
    search(grid,i,j+1);
  }//end search


}//end class Solution





