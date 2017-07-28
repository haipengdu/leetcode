package com.hdu;

/**
 * Created by hdu on 6/26/17.
 */
public class RemoveKDigits {

  public String removeKdigits(String num, int k) {
    if ( num == null || num.length() <= k )
      return "0";
    StringBuilder sb = new StringBuilder();
    int removedDigits = 0;

    for(int i =0; i < num.length(); i++){
      if (removedDigits < k && ( i == num.length() -1 || num.charAt(i) > num.charAt(i+1)) ){
        removedDigits++;
      }else{
        sb.append(num.charAt(i));
      }
    }

    if (removedDigits < k ){
      sb.delete(sb.length() - k + removedDigits, sb.length());
    }
    int index = 0;
    while (index < sb.length() && sb.charAt(index) == '0')
      index++;
    if (index >= sb.length())
      return "0";
    return sb.substring(index).toString();
  }
}
