package com.hdu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hdu on 6/20/17.
 */
public class FindPrime {
  public static void main(String [] args){
    long start = System.currentTimeMillis();
    List<Integer> result = getPrimes(1, 100000);
    CodeUtil.printObject(result);
    System.out.println(System.currentTimeMillis() - start);
  }

  public static List<Integer> getPrimes(int start, int end){
    List<Integer> primes = new ArrayList<>();
    if (start <= 0 || start > end){
      return primes;
    }

    if (start <= 2 ){
      primes.add(start);
      start++;
    }

    for(int n = start; n <= end; n++){
      if (isPrime(n)){
        primes.add(n);
      }
    }
    return primes;
  }

  private static boolean isPrime(int number){
    if (number == 2 || number == 3 || number == 5)
      return true;
   // if (number % 2 == 0 || number % 3 == 0 || number % 5 == 0 )
   //   return false;
    for(int n = 2; n <= Math.sqrt(number); n++){
      // if can find some number can be divided, it is not prime
      if ( number % n == 0 )
        return false;
    }
    return true;
  }
}
