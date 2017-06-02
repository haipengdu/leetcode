package com.hdu;

import java.util.Map;

/**
 * Created by hdu on 4/17/17.
 */
public class FindDifferenceInWord {
  public static void main(String [] args){

    CodeUtil.printObject(new FindDifferenceInWord().findTheDifference2("abc", "cbaa"));
    CodeUtil.printObject(new FindDifferenceInWord().findTheDifference("abc", "cbaa"));
  }

  public char findTheDifference2(String s, String t) {
    int [] occurs = new int[26];
    for(int i =0; i < s.length(); i++){
      occurs[s.charAt(i) - 'a']++;
    }
    for(int i =0; i < t.length(); i++){
      occurs[t.charAt(i) - 'a']--;
    }
    for(int i =0; i < occurs.length; i++){
      if (occurs[i] != 0){
        return (char) ('a' + i);
      }
    }
    return ' ';
  }

  public char findTheDifference(String s, String t) {
    int [] chars = new int [26];

    for(int i =0; i < s.length(); i++)
      chars[s.charAt(i) - 'a']++;

    for(int i =0; i < t.length(); i++)
      chars[t.charAt(i) - 'a']--;

    for(int i = 0; i < chars.length ; i++){

      if ( chars[i] != 0)
        return (char)('a' + i);
    }
    return  ' ';
  }
}
