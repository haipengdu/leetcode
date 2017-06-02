package com.hdu;

/**
 * Created by hdu on 4/20/17.
 */
public class NumberOfBoomerangs {

  public static void main(String [] args){
    int [][] points = new int[][]{
        {0,0},{1,0},{2,0}
    };
    CodeUtil.printObject(new NumberOfBoomerangs().numberOfBoomerangs(points));
  }

  public int numberOfBoomerangs(int[][] points) {

    if (points == null || points.length == 0 )
      return 0;
    int count = 0;
    for(int i = 0 ; i < points.length; i++){
      for( int j = 0; j < points.length; j++){
        for( int k =0; k < points.length; k++){
          if ( i == j || i == k || j == k)
            continue;

          if (isBoomerang(points[i], points[j], points[k]))
            count++;
        }
      }
    }

    return count;
  }

  private boolean isBoomerang(int[] point1, int[] point2, int[] point3) {
    return distance(point1, point2) == distance(point1, point3);
  }

  private int distance(int [] point1, int [] point2){
    return (point1[0] - point2[0]) * (point1[0] - point2[0]) + (point1[1] - point2[1])*(point1[1] - point2[1]);
  }
}
