package com.hdu;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hdu on 5/19/17.
 */
public class RomanToNumber {

  public static void main(String [] args){
    CodeUtil.printObject(new RomanToNumber().romanToInt("D"));
  }
  public int romanToInt(String s) {
    if ( s == null || s.length() == 0 )
      return 0;
    Map<Character, Integer> maps = new HashMap<>();

    maps.put('M', 1000);
    maps.put('D', 500);
    maps.put('C', 100);
    maps.put('L', 50);
    maps.put('X', 10);
    maps.put('V', 5);
    maps.put('I', 1);

    int result = 0;
    for(int i =0; i < s.length() - 1; i++){
      int current = maps.get(s.charAt(i));
      int next = maps.get(s.charAt(i+1));
      if ( current >= next)
        result += current;
      else
        result -= current;
    }
    result += maps.get(s.charAt(s.length() -1));
    return result;
  }
}
