package com.hdu;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hdu on 4/22/17.
 */
public class HappyNumber {

  public static void main(String [] args){
    CodeUtil.printObject(new HappyNumber().isHappy(19));
  }
  public boolean isHappy(int n) {
    if ( n == 0 )
      return false;
    if ( n == 1)
      return true;

    Set<Integer> touchedNumbers = new HashSet<>();

    int num = n;
    while(true){
      Integer squareNumber = calculate(num);
      if (squareNumber == 1)
        return true;
      if (touchedNumbers.contains(squareNumber))
        return false;
      touchedNumbers.add(squareNumber);
      num = squareNumber;
    }
  }

  private int calculate(int num) {
    int result = 0;
    while(num > 0){
      int digit = num % 10;
      num = num / 10;
      result += (digit * digit);
    }
    return result;
  }
}
