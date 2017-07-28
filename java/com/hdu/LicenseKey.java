package com.hdu;

import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Created by hdu on 6/7/17.
 */
public class LicenseKey {

  public static void main(String [] args){
    CodeUtil.printObject(new LicenseKey().licenseKeyFormatting("--abc-abc",  3));
    NavigableMap<Integer, Integer> map = new TreeMap<>();
    map.put(1, 10);
    map.put(1, 1);
    System.out.println(map);
  }
  public String licenseKeyFormatting(String s, int k) {
    if ( s == null || s.length() == 0 )
      return s;
    if ( k == 0 )
      return null;
    StringBuilder sb = new StringBuilder();
    int lettersLength = 0;
    for(int i =s.length() -1; i >=0; i--){

      Character licenseChar = transformLetter(s.charAt(i));
      if (licenseChar != null) {
        sb.insert(0, licenseChar);
        lettersLength++;

        if (i > 0 && lettersLength > 0 && lettersLength % k == 0) {
          sb.insert(0, '-');
        }
      }
    }
    if ( sb.length() > 0 && sb.charAt(0) == '-')
      sb.delete(0, 1);
    return sb.toString();
  }

  private Character transformLetter(char c){
    if ( (c >= 'A' && c <= 'Z') || ( c >= '0' && c <= '9') )
      return c;
    if ( c >= 'a' && c <= 'z')
      return Character.toUpperCase(c);
    return null;
  }
}
