package com.hdu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by hdu on 5/31/17.
 */
public class ReconstructQueue {
  public static void main(String [] args){
    new ReconstructQueue().reconstructQueue(new int [][]  { {7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2} });
  }
  public int[][] reconstructQueue(int[][] people) {

    Arrays.sort(people, (a, b) ->{
      if ( a[0] != b[0])
        return  b[0] - a[0];
      return  a[1] - b[1];
    });
    for(int [] data : people){
      System.out.println(Arrays.toString(data));
    }

    List<int[]> tmp = new ArrayList<>();
    for( int [] data : people)
      tmp.add(data[1], data);

    int [][] result = new int[people.length][2];
    result = tmp.toArray(result);
    /*
    for(int i = 0; i < people.length; i++){
      int [] data = people[i];
      if ( data[1] != i){
        int [] insertData = data;
        shiftArray(people, data[1], i);
        people[insertData[1]] = insertData;
      }
    }*/

    for(int [] data : result){
      System.out.println(Arrays.toString(data));
    }
    return result;
  }

  private void shiftArray(int[][] people, int start, int end) {
    for( int i = end -1; i >= start; i-- ){
      System.out.println(i);
      people[i+1] = people[i];
    }
  }

  public int[][] reconstructQueue2(int[][] people) {
    if (people == null || people.length == 0 || people[0].length == 0)
      return new int[0][0];

    Arrays.sort(people, new Comparator<int[]>() {
      public int compare(int[] a, int[] b) {
        if (b[0] == a[0]) return a[1] - b[1];
        return b[0] - a[0];
      }
    });

    int n = people.length;
    ArrayList<int[]> tmp = new ArrayList<>();
    for (int i = 0; i < n; i++)
      tmp.add(people[i][1], new int[]{people[i][0], people[i][1]});

    int[][] res = new int[people.length][2];
    int i = 0;
    for (int[] k : tmp) {
      res[i][0] = k[0];
      res[i++][1] = k[1];
    }

    return res;
  }

}
