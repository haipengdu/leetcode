package com.hdu;

/**
 * Created by hdu on 4/17/17.
 */
public class IslandPerimeter {

  public static void main(String[] args) {
    int[][] grid = new int[][]{
        new int[]{0, 1, 0, 0},
        new int[]{1, 1, 1, 0},
        new int[]{0, 1, 0, 0},
        new int[]{1, 1, 0, 0}
    };
    CodeUtil.printObject(new IslandPerimeter().islandPerimeter(grid));
  }

  public int islandPerimeter(int[][] grid) {
    int perimeter = 0;
    for(int i =0; i < grid.length; i++){
      for(int j =0; j < grid[i].length; j++){
        if (grid[i][j] == 0 ){
          continue;
        }
        if ( i - 1 < 0 || grid[i-1][j] == 0 )
          perimeter++;
        if (i+1 >= grid.length || grid[i+1][j] == 0 )
          perimeter++;
        if (j-1 < 0 || grid[i][j-1] == 0)
          perimeter++;
        if (j+1 >= grid[i].length || grid[i][j+1] == 0)
          perimeter++;
      }
    }
    return perimeter;
  }
}
