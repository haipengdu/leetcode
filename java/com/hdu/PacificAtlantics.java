package com.hdu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by hdu on 7/13/17.
 */
public class PacificAtlantics {

  public static void  main(String [] args){
    int [][] matrix = new int[][]
        {   {1,2,2,3,5},
            {3,2,3,4,4},
            {2,4,5,3,1},
            {6,7,1,4,5},
            {5,1,1,2,4}};
    int [][] matrix2 = new int[][]{
        {1,1}, {1,1}, {1,1}
    };

    int [][] matrix3 = new int[][]{
        {3,3,3,3,3,3},{3,0,3,3,0,3},{3,3,3,3,3,3}
    };

    List<int[]> result = new PacificAtlantics().pacificAtlantic(matrix3);
    for(int [] point : result){
      System.out.println(Arrays.toString(point));
    }
  }
  public List<int[]> pacificAtlantic(int[][] matrix) {
    if ( matrix == null || matrix.length == 0 )
      return new ArrayList<>();

    List<int[]> pacificEntries = new ArrayList<>();
    List<int[]> atlanticEntries = new ArrayList<>();

    int rows = matrix.length;
    int cols = matrix[0].length;

    for(int i =0; i < rows; i++){
      pacificEntries.add(new int[]{i, 0});
      atlanticEntries.add(new int[] {i, cols -1});
    }

    for(int j =0; j < cols; j++){
      pacificEntries.add(new int[]{0, j});
      atlanticEntries.add(new int[] {rows -1, j});
    }

    int [][] pacific =  getFlowedPositions(matrix, pacificEntries, rows, cols );
    int [][] atlantic = getFlowedPositions(matrix, atlanticEntries, rows, cols );


    List<int[]> commonPoints = new ArrayList<>();
    for( int i =0; i < rows; i++){
      for(int j =0; j < cols; j++){
        if (pacific[i][j] == atlantic[i][j] && pacific[i][j] > 0)
          commonPoints.add(new int[] {i, j});
      }
    }
    return commonPoints;
  }

  private int[][] getFlowedPositions(int[][] matrix, List<int[]> entries, int rows, int cols) {

       int [][] flows = new int[rows][cols];
       Queue<int[]> queue = new LinkedList<>();

       for(int [] point : entries){
         flows[point[0]][point[1]] = 1;
          queue.offer(point);
       }

       int [][] delta = new int[][] { {-1,0}, {1,0}, {0,-1}, {0, 1}  };
       while(!queue.isEmpty()){
         int [] point = queue.poll();
         flows[point[0]][point[1]] = 1;
         for(int [] d : delta){
           int i = point[0] + d[0];
           int j = point[1] + d[1];
           int height = matrix[point[0]][point[1]];
           if ( i >= 0 && i < rows && j >= 0 && j < cols &&
               flows[i][j] ==0 && height <= matrix[i][j])
             queue.offer(new int[] {i, j});
         }
       }
       return flows;
  }
}
