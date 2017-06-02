package com.hdu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hdu on 4/16/17.
 */
public class FizzBuzz {

  public static void main(String [] args){
    System.out.println(new FizzBuzz().fizzBuzz(15));
  }
  public List<String> fizzBuzz(int n) {
    if ( n <= 0 ){
      return new ArrayList<>();
    }
    List<String> result = new ArrayList<>();

    for(int i = 1 ; i <= n; i++){
      String s = "";
      if ( i % 3 == 0 ){
        s += "Fizz";
      }
      if ( i % 5 == 0 ){
        s += "Buzz";
      }
      if (s.length() == 0 ){
        s = "" + i;
      }
      result.add(s);
    }
    return result;
  }

  public List<String> fizzBuzz2(int n) {
    if ( n <= 0 )
      return new ArrayList<>();
    List<String> result = new ArrayList<>();
    for(int i =1; i <= n; i++){
      StringBuilder sb = new StringBuilder();
      if ( i % 3 == 0 )
        sb.append("Fizz");
      if ( i % 5 == 0)
        sb.append("Buzz");
      if ( sb.length() == 0 )
        sb.append(i);
      result.add(sb.toString());
    }
    return result;
  }
}
