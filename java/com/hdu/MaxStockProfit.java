package com.hdu;

/**
 * Created by hdu on 5/18/17.
 */
public class MaxStockProfit {

  public int maxProfit(int[] prices){
    int result = 0;
    if (prices == null || prices.length < 2)
      return result;
    for(int i = 1; i < prices.length; i++){
      result += Math.max(prices[i] - prices[i-1], 0);
    }
    return result;
  }
}
