package com.hdu;

/**
 * Created by hdu on 4/17/17.
 */
public class DetectCapitalUse {

  public static void main(String [] args){
    CodeUtil.printObject(new DetectCapitalUse().detectCapitalUse("USA"));
    CodeUtil.printObject(new DetectCapitalUse().detectCapitalUse2("USA"));
  }
  public boolean detectCapitalUse2(String word) {


    boolean hasSmallCase = word.charAt(0) >= 'a';
    boolean hasCapitalCase = !hasSmallCase;
    boolean onlyCapitalAtFirst = hasCapitalCase;

    for(int i = 1; i < word.length(); i++) {
      char c = word.charAt(i);
      boolean isSmall = word.charAt(i) >= 'a';
      if (isSmall){
        if (hasCapitalCase && !onlyCapitalAtFirst)
          return false;
        hasSmallCase = true;
      }else{
        if (hasSmallCase)
          return false;
        hasCapitalCase = true;
        onlyCapitalAtFirst = false;
      }
    }

    return true;
  }

  public boolean detectCapitalUse(String word) {
    if ( word == null || word.length() == 0 )
      return false;
    char first = word.charAt(0);
    boolean firstOneCaptial = first >= 'A' && first <= 'Z';
    boolean hasSmallCase = !firstOneCaptial;
    boolean hasCaptialAfterFirst = false;
    for(int i =1; i < word.length(); i++){
      char c = word.charAt(i);
      if (c >= 'A' && c <= 'Z' ){
        if (hasSmallCase)
          return false;
        hasCaptialAfterFirst = true;
      }else{
        if (hasCaptialAfterFirst)
          return false;
        hasSmallCase = true;
      }
    }
    return true;
  }
}
