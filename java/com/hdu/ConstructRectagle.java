package com.hdu;

/**
 * Created by hdu on 5/16/17.
 */
public class ConstructRectagle {

  public static void main(String [] args){
    CodeUtil.printArray(new ConstructRectagle().constructRectangle(9));
  }
  public int[] constructRectangle(int area){
    if (area <= 0)
      return new int[] {0, 0};
    int l =(int) Math.ceil(Math.sqrt(area));

    if ( l * l == area)
      return new int []{l, l};
    while( l == 1 || area%l != 0)
      l++;
    return new int[]{l, area/l};
  }
}
