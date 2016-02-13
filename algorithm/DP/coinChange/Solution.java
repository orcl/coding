/* Coin change
 * you are given coins of different denominations of a total amount of money amount. 
 * write a function to compute the fewest number of coins that you need to make up that amount.
 * if that amount of money cann't be made up by any combination of the coins, return -1.
 *
 * example 1:
 * coins = [1,2,5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 *
 * example 2:
 * coins = [2], amount = 3
 * return -1.
 *
 * Note:
 * you may assume that you have an infinite number of each kind of coin.
 */


//Solve it with dp.
public class Solution {
    
    public int coinChange(int[] coins, int amount) {
        int m[] = new int[amount+1];
        Arrays.fill(m,Integer.MAX_VALUE);
        HashSet<Integer> coinSet = new HashSet<Integer>();
        for (int num : coins) {
            coinSet.add(num);
        }
        m[0] = 0;
        for (int i = 1; i <= amount; i++) {
            if (coinSet.contains(i)) {
                m[i] = 1;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (m[i] != -1 && m[i-j] != -1) {
                    m[i] = Math.min(m[j] + m[i-j], m[i]);
                }
            }
            if (m[i] == Integer.MAX_VALUE) {
                m[i] = -1;
            }
        }
        return m[amount];
    }

}




