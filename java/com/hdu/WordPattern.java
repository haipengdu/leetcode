package com.hdu;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hdu on 4/24/17.
 */
public class WordPattern {

  public static void main(String [] args){
    CodeUtil.printObject(new WordPattern().wordPattern("abbca", "dog cat cat fish dog"));
  }
  public boolean wordPattern(String pattern, String str) {

    if (pattern == null || pattern.length() == 0)
      return true;
    if (str == null || str.length() == 0)
      return false;
    Map<Character, String> patternValues = new HashMap<Character, String>();
    String [] items = str.split(" ");

    int pos = 0;
    for(int i =0; i < items.length ; i++){
      char p = pattern.charAt(pos % pattern.length());
      String patternValue = patternValues.get(p);
      if (patternValue == null){
        if (patternValues.values().contains(items[i]))
          return false;
        patternValues.put(p, items[i]);
      }else if (!patternValue.equals(items[i])){
        return false;
      }
      pos++;
    }
    return pos % pattern.length() == 0;
  }
}
