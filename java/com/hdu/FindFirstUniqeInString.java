package com.hdu;

/**
 * Created by hdu on 4/19/17.
 */
public class FindFirstUniqeInString {

  public int firstUniqChar2(String s) {
    if ( s == null || s.length() == 0 )
      return -1;
    int [] chars = new int[26];
    int [] uniques = new int[26];

    for(int i =0; i < s.length(); i++){
      chars[s.charAt(i) - 'a']++;
    }

    for(int i =0; i < s.length(); i++){
      if ( chars[s.charAt(i) - 'a'] == 1 )
        return i;
    }
    return -1;
  }

  public int firstUniqChar(String s){
    if (s == null || s.length() == 0)
      return -1;
    int [] chars = new int[26];
    for(int i =0; i < s.length(); i++)
      chars[s.charAt(i) - 'a']++;
    for(int i =0; i < s.length(); i++){
      if (chars[s.charAt(i) - 'a'] == 1)
        return i;
    }
    return -1;
  }
}
