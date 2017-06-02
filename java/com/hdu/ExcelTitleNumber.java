package com.hdu;

/**
 * Created by hdu on 5/18/17.
 */
public class ExcelTitleNumber {

  public static void main(String [] args){
    CodeUtil.printObject(new ExcelTitleNumber().titleToNumber("A"));
    CodeUtil.printObject(new ExcelTitleNumber().titleToNumber("BA"));
  }
  public int titleToNumber(String s) {
    if (s == null || s.length() == 0)
      return 0;
    int result  = 0;
    int factor = 1;
    for(int i =s.length()-1; i >= 0; i--){
      char c = s.charAt(i);
      result += factor*( c-'A' + 1);
      factor *= 26;
    }

    return result;
  }
}
