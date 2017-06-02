package com.hdu;

import java.util.Arrays;

/**
 * Created by hdu on 4/26/17.
 */
public class KthSmallestInSortedMatrix {

  public static void main(String [] args){
    int [][] matrix = new int [][]{
        { 1,  5,  9},
        {10, 11, 13},
        {12, 13, 15}
    };
    CodeUtil.printObject(new KthSmallestInSortedMatrix().kthSmallest(matrix, 8));
  }
  public int kthSmallest(int[][] matrix, int k) {

    int [] pos = new int [matrix.length];

    int result = 0;

    for(int left = 0; left < k ; left++){
        int min  = Integer.MAX_VALUE;
        int row = 0;
      for(int r = 0; r < matrix.length; r++){
        if (pos[r] < matrix.length && matrix[r][pos[r]] <= min){
          min = matrix[r][pos[r]];
          row = r;
        }
      }
      pos[row]++;
      result = min;
    }
    return result;
  }
}
