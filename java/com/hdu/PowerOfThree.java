package com.hdu;

/**
 * Created by hdu on 4/23/17.
 */
public class PowerOfThree {

  public static void main(String [] args ){
    int n = 10;
    System.out.println( n & 1) ;
    CodeUtil.printObject(new PowerOfThree().isPowerOfThree(4));
  }
  public boolean isPowerOfThree(int n) {

    if (n == 0) {
      return false;
    }
    if (n == 1) {
      return true;
    }
    while (n >= 3) {
      if (n % 3 != 0) {
        return false;
      }
      n = n / 3;
    }

    return n == 1;
  }

  public boolean isPowerOfTwo(int n) {
    if(n<=0) return false;
    return (n & (n-1)) == 0;
  }
}
