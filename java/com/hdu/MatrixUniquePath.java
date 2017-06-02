package com.hdu;

/**
 * Created by hdu on 4/26/17.
 */
public class MatrixUniquePath {

  public int uniquePaths(int m, int n) {

    int [][] paths = new int[m][n];
    for(int i =0; i < m; i++)
      paths[i][0] = 1;
    for( int i =0; i < n; i++)
      paths[0][i] = 1;

    for(int r = 1; r < m; r++){
      for( int c = 1; c < n; c++){
        paths[r][c] = paths[r-1][c] + paths[r][c-1];
      }
    }

    return paths[m-1][n-1];
  }
}
