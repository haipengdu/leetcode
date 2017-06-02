package com.hdu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hdu on 4/24/17.
 */
public class RestoreIp {

  public  static void main(String [] args){
    CodeUtil.printObject(new RestoreIp().restoreIpAddresses("25525511135"));
  }
  public List<String> restoreIpAddresses(String s) {

    List<String> ips = new ArrayList<>();
    if (s == null || s.length() < 4)
      return ips;

    for(int first =1; first <= 3 ; first++){
      String firstPart = s.substring(0, first);
      if (!isValidIp(firstPart))
         break;

      for(int second =1; second <= 3 && second + first < s.length(); second++){
        String secondPart = s.substring(first, second + first);
        if (!isValidIp(secondPart))
          break;
        for(int third = 1; third <= 3 && second + first + third < s.length(); third++){
            String thirdPart = s.substring(second + first, second + first + third);
            String fourthPart =  s.substring(first + second + third);
            if (isValidIp(thirdPart) && isValidIp(fourthPart)){
              ips.add(String.format("%s.%s.%s.%s", firstPart, secondPart, thirdPart, fourthPart));
            }

        }
      }
    }
    return ips;
  }

  private boolean isValidIp(String item){
    if ( item.length() > 3 )
      return false;
    int value = Integer.valueOf(item);
    if ( value == 0){
      return item.length() == 1;
    }

    if ( item.startsWith("0"))
      return false;

    return value < 256;
  }
}
