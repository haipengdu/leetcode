package com.hdu;

/**
 * Created by hdu on 5/14/17.
 */
public class ReverseString {

  public String reverseString(String s ){
    if ( s == null || s.length() < 2)
      return s;
    char [] chars = new char[s.length()];
    for( int i = 0; i< s.length()/2; i++){
      chars[i] = s.charAt(s.length() - 1 - i);
      chars[s.length() - 1 - i] = chars[i];
    }
    return new String(chars);
  }
}
