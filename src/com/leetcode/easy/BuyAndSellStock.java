package com.leetcode.easy;

/**
 * 121. Best Time to Buy and Sell Stock
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 *
 * Example:
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 *
 * Solution:
 * For each iteration, if p[i]<min, then min=p[i].
 *                     else calc profit and maxProfit.
 */
public class BuyAndSellStock {

    public int maxProfit(int[] prices) {
        if(prices == null||prices.length<2) return 0;
        int min = prices[0];
        int maxProfit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<min){
                min=prices[i];
            }
            else{
                int profit = prices[i]-min;
                if(profit>maxProfit)
                    maxProfit=profit;
            }
        }
        return maxProfit;
    }
}
