package com.hdu;

/**
 * Created by hdu on 4/20/17.
 */
public class ReverseStringWith2K {

  public static  void main(String [] args){
    CodeUtil.printObject(new ReverseStringWith2K().reverseStr("abcdf", 3));
  }
  public String reverseStr(String s, int k) {

    if ( s == null || s.length() == 0)
      return "";
    int numberOfChars = 2 * k;
    boolean isReverse = false;
    StringBuilder result = new StringBuilder();
    StringBuilder current = new StringBuilder();

    for( int i =0 ; i < s.length(); i++){
      if ( i % k == 0){
        result.append(current);
        isReverse = !isReverse;
        current = new StringBuilder();
      }
      if (isReverse)
        current.insert(0, s.charAt(i));
      else
        current.append(s.charAt(i));
    }
    result.append(current);

    return result.toString();
  }
}
