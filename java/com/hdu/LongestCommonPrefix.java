package com.hdu;

/**
 * Created by hdu on 5/20/17.
 */
public class LongestCommonPrefix {

  public static void main(String [] args){
    CodeUtil.printObject("a".substring(0, 0));
  }
  public String longestCommonPrefix(String[] strs){
    if ( strs == null || strs.length == 0)
      return "";
    if (strs.length == 1)
      return strs[0];
    String smallest = strs[0];
    for(int i = 1; i < strs.length; i++){
      if (strs[i].length() < smallest.length())
        smallest = strs[i];
    }

    String commonPrefix = smallest;
    while(commonPrefix.length() > 0){
      int items = 0;
      for(items = 0; items < strs.length; items++){
        if (!strs[items].startsWith(commonPrefix)){
         // if (commonPrefix.length() == 1)
         //   commonPrefix = "";
         // else
            commonPrefix = commonPrefix.substring(0, commonPrefix.length()-1);
          break;
        }
      }
      if (items == strs.length)
        return commonPrefix;

    }
    return "";
  }
}
