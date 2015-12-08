/*
 * given a rope with positive integer-length n, how to cut the rope into m integer-length parts with length p[0], p[1], ... , p[m-1],
 * in order to get the maximal product of p[0] * p[1] * ..... p[m-1]?
 * m is determined by you and must be greater than 0 (at least one cut must be made). 
 * return the max product you can have.
 *
 * Assumptions:
 *  n >= 2
 *
 *  Examples:
 *      n = 12, the max product is 3 * 3 * 3 * 3 = 81 (cut the rope into 4 pieces with length of each is 3).
 */

//solve this problem with recursion
//

public class Solution {

    public int maxProduct(int n) {
        if (n <= 1) {
            return 0;  //base case
        }

        int maxProduct = 0;
        for (int i = 1; i < n; i++) {
            int best = Math.max(n-i, maxProduct(n-i));
            maxProduct = Math.max(maxProduct, i*best);
        }
    
        return maxProduct;
    }


    public int maxProduct1(int n) {
        if (n <= 1) {
            return 0;  //base case
        }
        
        int[] m = new int[n+1];
        //induction rule:
        //m[i] represents the largest products can be made by cutting i-meters rope into several sections.
        m[0] = 0;
        m[1] = 0;
        for (int i = 2; i <= n; i++) {
            //i is the value of the rope that we are growing.
            m[i] = 01;
            for (int j = 1; j <= i/2; j++) {
                m[i] = Math.max(m[i], Math.max(i-j, m[i-j]) * Math.max(j, m[j]));
                //loop throug all the possible cut places.
            }
        }//end for loop

        return m[n];
    }

}//end Solution






