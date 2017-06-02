package com.hdu;

/**
 * Created by hdu on 5/12/17.
 */
public class ReshapeMatrix {

  public int[][] matrixReshape(int[][] nums, int r, int c) {
    if ( r*c != nums.length * nums[0].length)
      return nums;
    int [][] results = new int[r][c];


     for( int i = 0; i < r; i++){
       for(int j = 0; j < c; j++){
          int index = i * c + j;
          int currentRow = index / nums[0].length;
          int currentCol = index % nums[0].length;
          results[i][j] = nums[currentRow][currentCol];
       }
     }
     return results;
  }
}
