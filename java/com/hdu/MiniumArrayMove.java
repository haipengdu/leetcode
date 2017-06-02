package com.hdu;

/**
 * Created by hdu on 5/19/17.
 */
public class MiniumArrayMove {

  public  static void main(String [] args){
    CodeUtil.printObject(new MiniumArrayMove().convertToBase7(100));
  }
  public int minumMove(int [] nums){
    if ( nums == null || nums.length < 2)
      return 1;
    int min = Integer.MAX_VALUE;
    for(int i : nums){
      if ( i < min)
        min = i;
    }
    int moves = 0;
    for(int i : nums){
      moves += (i - min);
    }
    return moves;
  }

  public String convertToBase7(int num){
    if ( num == 0 )
      return "0";

    String sign = "";
    if ( num < 0 ){
      sign = "-";
      num = -1 * num;
    }

    StringBuilder sb = new StringBuilder();
    while (num > 0){
      sb.insert(0, num %7);
      num = num / 7;
    }
    return sign + sb.toString();
  }
}
