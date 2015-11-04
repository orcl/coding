public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;

        while (n > 2) {
            int t = n>>1;
            int s = t<<1;
            if (n != s) {
                return false;
            }

            n = n >> 1;
        }//end while

        return true;
    }

}
