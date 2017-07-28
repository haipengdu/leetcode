package com.hdu;

/**
 * Created by hdu on 7/18/17.
 */
public class OutOfBoundary {

  public static void main(String [] args){
    int result = new OutOfBoundary().findPaths(1,3,3,0,1);
    System.out.println(result);
  }
  public int findPaths(int m, int n, int steps, int i, int j) {
    int mod = 1000000000 + 7;
    if (steps == 0 )
      return 0;
    int [][] last = new int[m][n];
    int [][] current = new int[m][n];

    last[i][j] = 1;
    int total = 0;
    int [][] delta = new int[][] { {0,1}, {1,0}, {0,-1},{-1,0}};
    for(int s = 0; s <= steps; s++){
      current = new int[m][n];
      for(int r =0 ; r < m; r++){
        for(int c =0; c < n; c++){
          for(int [] dir : delta){
            int rc = r + dir[0];
            int cc = c + dir[1];
            if ( rc >= 0 && rc < m && cc >=0 && cc< n)
              total += (last[rc][cc]%mod);
          }
          current[r][c] = (total + last[r][c] ) %mod;
        }
      }
      last = current;
      CodeUtil.printMatrix(last);
    }
    return current[i][j];
  }


}
