package com.hdu;

/**
 * Created by hdu on 4/19/17.
 */
public class IsAnagramStrings {

  public boolean isAnagram(String s, String t) {
    if (s == null || t == null )
      return false;
    if (s.length() != t.length())
      return false;

    int [] schars = new int[26];
    int [] tchars = new int[26];

    for(int i =0; i < s.length(); i++){
      schars[s.charAt(i) - 'a']++;
      tchars[t.charAt(i) - 'a']++;
    }

    for(int i =0; i < 26; i++){
      if (schars[i] != tchars[i])
        return false;
    }
    return true;
  }
}
