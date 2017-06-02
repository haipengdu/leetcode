package com.hdu;

/**
 * Created by hdu on 4/15/17.
 */
public class HammingDistance {

  public static void main(String [] args){
    System.out.println( hammingDistance(1,2));
    System.out.println( hammingDistance2(1,2));
  }

  public static int hammingDistance(int x, int y) {

    if ( x == y ){
      return 0;
    }
    int mask = 1;
    int distance = 0;

    for (int i =0; i < 32; i++){
      int same = ( (x & mask) ^ (y & mask) ) > 0 ? 1: 0;
      distance += same;
      mask  *= 2;
    }
    return distance;
  }

  public static int hammingDistance2(int x, int y) {

   if ( x == y )
     return 0;
    return Integer.bitCount( x ^ y);
  }

}
