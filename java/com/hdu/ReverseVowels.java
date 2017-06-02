package com.hdu;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by hdu on 4/24/17.
 */
public class ReverseVowels {
  public String reverseVowels(String s) {
    if ( s == null || s.length() < 2)
      return s;
    Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    char [] chars = s.toCharArray();
    int low = 0;
    int high = s.length() -1;
    while(low < high){
       while( low < chars.length && !vowels.contains(chars[low]))
         low++;
       while( high > 0 && !vowels.contains(chars[high]))
         high--;
      if (low < high){
        char tmp = chars[low];
        chars[low] = chars[high];
        chars[high] = tmp;
        low++; high--;
      }
    }
    return new String(chars);
  }
}
