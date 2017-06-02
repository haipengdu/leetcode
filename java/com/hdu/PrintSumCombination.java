package com.hdu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hdu on 4/25/17.
 */
public class PrintSumCombination {

  public static void main(String [] args){
    new PrintSumCombination().printSumCombination(5, 4);
  }
  public void printSumCombination (int sum, int n){
    printSumCombinationInternal(sum, n, new ArrayList<>());
  }

  public void printSumCombinationInternal(int sum, int n, List<Integer> preNumbers){
    if ( n == 1 ){
      for(Integer num : preNumbers)
        System.out.print(num + " ");
      System.out.println(sum);
      return;
    }

    for( int i =0; i <= sum; i++){
      List<Integer> numbers = new ArrayList<>(preNumbers);
      numbers.add(i);
      printSumCombinationInternal(sum-i, n-1, numbers);
    }
  }
}
