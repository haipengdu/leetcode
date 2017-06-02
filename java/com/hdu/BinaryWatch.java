package com.hdu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hdu on 5/21/17.
 */
public class BinaryWatch {

  public List<String> readBinaryWatch(int num) {
    if ( num <= 0 )
      return new ArrayList<>();
    List<String> times = new ArrayList<>();
    for( int hour = 0; hour < 12; hour++){
      for( int min =0; min < 60; min++){
        int hourBit = Integer.bitCount(hour);
        int minBit = Integer.bitCount(min);
        if (hourBit + minBit == num){
          times.add(String.format("%d:%02d", hour, min));
        }
      }
    }
    return times;
  }
}
