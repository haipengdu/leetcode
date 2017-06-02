package com.hdu;

/**
 * Created by hdu on 4/18/17.
 */
public class CanConstructRansomNote {
  public static void main(String [] args){

    CodeUtil.printObject(new CanConstructRansomNote().canConstruct("a", "b"));
    CodeUtil.printObject(new CanConstructRansomNote().canConstruct("aa", "ab"));
    CodeUtil.printObject(new CanConstructRansomNote().canConstruct("aa", "aab"));
    CodeUtil.printObject(new CanConstructRansomNote().canConstruct("", ""));
  }

  public boolean canConstruct2(String ransomNote, String magazine) {
    if (ransomNote == null || magazine == null)
      return false;
    if ( ransomNote.length() > magazine.length())
      return false;
    int [] chars = new int[26];
    for(int i =0; i < magazine.length(); i++)
      chars[magazine.charAt(i) - 'a']++;
    for(int i =0; i < ransomNote.length(); i++){
      char c = ransomNote.charAt(i);
      if (chars[c-'a'] <= 0)
        return false;
      chars[c-'a']--;
    }
    return true;
  }

  public boolean canConstruct(String ransomNote, String magazine) {
    if (ransomNote == null || magazine == null )
      return false;
    int [] chars = new int[26];

    for(int i =0; i < magazine.length(); i++){
      chars[magazine.charAt(i) - 'a']++;
    }

    for(int i =0; i < ransomNote.length(); i++){
      int pos = ransomNote.charAt(i) - 'a';
      if (chars[pos] <= 0 ){
        return false;
      }
      chars[pos]--;
    }
    return true;
  }
}
