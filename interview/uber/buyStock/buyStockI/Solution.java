/*
 * Best time to buy and sell stock 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * if you were only permitted to complete at most one transaction(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.)
 */



public class Solution {

  public int maxProfit(int[] prices) {
  
    //instead of keeping track of largest element in the array, we track the maximum profit so far.
    //minPrice is the min price so far. so we keep track of the min price, we can calculate the max profit so far.

    int profit = 0;
    int minPrice = Integer.MAX_VALUE;
    for (int i = 0; i < prices.length; i++) {
      profit = Math.max(profit, prices[i] - minPrice);
      minPrice = Math.min(minPrice, prices[i]);
    }
    return profit;
  }
}
