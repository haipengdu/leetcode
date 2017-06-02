package com.hdu;

/**
 * Created by hdu on 4/24/17.
 */
public class RepeatedSubstringPattern {

  public static void main(String [] args){
    CodeUtil.printObject(new RepeatedSubstringPattern().repeatedSubstringPattern("abcabcabcabc"));
  }

  public boolean repeatedSubstringPattern(String s) {

    for(int i =1; i <= s.length() / 2; i++){
      if (s.length() % i != 0)
        continue;;
      String pattern = s.substring(0, i);
      int k;
      for( k = i ; k < s.length(); k+=i){
        if (!s.substring(k, k+i).equals(pattern))
          break;
      }
      if ( k >= s.length())
        return true;
    }
    return false;
  }
}
