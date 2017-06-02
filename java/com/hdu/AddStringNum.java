package com.hdu;

/**
 * Created by hdu on 4/22/17.
 */
public class AddStringNum {

  public static  void main(String [] args){
    int a = 3;
   // CodeUtil.printObject(new AddStringNum().addStrings("99", "777"));
  }
  public String addStrings(String num1, String num2) {
    if (num1 == null || num1.length() == 0) {
      return num2;
    }
    if (num2 == null || num2.length() == 0) {
      return num1;
    }

    String shortNum = num1.length() >= num2.length() ? num2 : num1;
    String longNum = num1.length() >= num2.length() ? num1 : num2;

    StringBuilder result = new StringBuilder();

    int i = 0;
    int carry = 0;

    for (i = 0; i < shortNum.length(); i++) {
      int n1 = shortNum.charAt(shortNum.length() - i - 1) - '0';
      int n2 = longNum.charAt(longNum.length() - i - 1) - '0';
      result.insert(0, (n1 + n2 + carry) % 10);
      carry = (n1 + n2 + carry) / 10;
    }

    for( i = shortNum.length() ; i < longNum.length(); i++){
      int n = longNum.charAt(longNum.length() - i - 1) - '0';
      result.insert(0, (n+carry) % 10);
      carry = (n + carry) / 10;
    }
    if ( carry > 0)
      result.insert(0, carry);
    return result.toString();
  }
}
