package com.hdu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hdu on 4/21/17.
 */
public class ReadBinaryWatch {

  public static void main(String [] args){
    CodeUtil.printObject(new ReadBinaryWatch().readBinaryWatch(1));
  }
  public List<String> readBinaryWatch(int num) {

    List<String> result = new ArrayList<>();
    if ( num == 0 )
      return result;

    for( int hour = 0; hour < 12; hour++){
      for( int min =0; min < 60; min++){
        int hourBit = Integer.bitCount(hour);
        int minBit = Integer.bitCount(min);
        if (hourBit + minBit == num){
          result.add(String.format("%d:%02d", hour, min));
        }
      }
    }

    return result;
  }
}
