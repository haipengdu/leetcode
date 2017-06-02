package com.hdu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by hdu on 5/30/17.
 */
public class BeautifulArrangement {

  public static void main(String[] args) {
    CodeUtil.printObject(new BeautifulArrangement().countArrangement(5));

  }

  int arrangementCount = 0;

  public int countArrangement(int n) {
    if (n <= 1) {
      return 1;
    }
    int [] usedPositions = new int[n + 1];
    countArrangement(n, usedPositions);
    return arrangementCount;
  }

  private void countArrangement(int n, int[] usedPositions) {
    if (n == 1) {
      arrangementCount++;
      return;
    }
    for( int i =1; i <= usedPositions.length -1; i++){
      if (usedPositions[i] == 0 && isPlaceable(n, i)){
        usedPositions[i] = n;
        countArrangement(n-1, usedPositions);
        usedPositions[i] = 0;
      }
    }
  }

  private boolean isPlaceable(int num, int pos) {
    return num % pos == 0 || pos % num == 0;
  }
}
