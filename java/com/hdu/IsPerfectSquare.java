package com.hdu;

/**
 * Created by hdu on 5/22/17.
 */
public class IsPerfectSquare {
  public static void main(String [] args){
    CodeUtil.printObject(new IsPerfectSquare().isPerfectSquare(16));
  }
  public boolean isPerfectSquare(int num) {
    return isPerfectSquare(num, 1, num );
  }

  public boolean isPerfectSquare(int origNum, int low, int high){

    if (origNum == 1 )
      return true;
    if ( low >= high  )
      return false;

    int middle = low/2 + high/2;
    if ( middle * middle == origNum)
      return true;
    System.out.println(low + " " + high + " " + middle);
    if ( middle * middle > origNum)
      return isPerfectSquare(origNum, low+1, middle);
    return isPerfectSquare(origNum, middle, high -1);
  }
}
