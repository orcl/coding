Rotate image
you are given nxn 2d matrix representing an image.
rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?



public class Solution {



    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < Math.ceil(((double)n)/2.0); j++) {
                int temp = matrix[i][j];
                matrix[i][j]         = matrix[n-j-1][i];
                matrix[n-1-j][i]     = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i]     = temp;
            }
        }
    }//end rotate

}//end class Solution



//hint:

(0,n)     --->      (n,n)

           
  |                   |
  |                   |
  |                   |


(0,0)      <---     (n,0)

leads to:

(j,n-1-i)   --->   (n-i-1,n-j-1)

  
  |                    |
  |                    |
  |                    |


(i,j)      <---      (n-j-1, i)


    look above,
    (i,j)  goes above to (j),  means   (n-j-1,i) goes left to (n-j-1)
    (i,j)  goes right to (i),  means   (n-j-1,i) goes above to (i)






