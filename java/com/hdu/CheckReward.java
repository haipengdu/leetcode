package com.hdu;

/**
 * Created by hdu on 4/21/17.
 */
public class CheckReward {

  public static void main(String [] args){
    CodeUtil.printObject(new CheckReward().checkRecord("PPALLP"));
  }
  public boolean checkRecord(String s) {
    if (s == null || s.length() == 0)
      return true;
    int numOfLateInLine = 0;
    int numOfAbsent = 0;
    for(int i =0; i < s.length(); i++){
      char status = s.charAt(i);
      if (status == 'A')
        numOfAbsent++;
      if (status != 'L')
        numOfLateInLine =0;
      else
        numOfLateInLine++;
      if (numOfLateInLine > 2 || numOfAbsent > 1)
        return false;
    }
    return true;
  }
}
