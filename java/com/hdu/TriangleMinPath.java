package com.hdu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hdu on 7/9/17.
 */
public class TriangleMinPath {

  public int minimumTotal(List<List<Integer>> triangle) {
   if (triangle == null || triangle.size() == 0 )
     return 0;
   if ( triangle.size() == 1 )
     return triangle.get(0).get(0);
   List<Integer> pathSum = new ArrayList<>();

   pathSum.add(triangle.get(0).get(0));

   for(int i =1; i < triangle.size(); i++){
     List<Integer> currentData = triangle.get(i);
     List<Integer> currentPathSum = new ArrayList<>();
      for(int j =0; i < currentData.size(); j++){
        int first = j - 1 >=0 ? currentData.get(j) + pathSum.get(j-1) : Integer.MAX_VALUE;
        int second = j < pathSum.size() ? currentData.get(j) + pathSum.get(j) : Integer.MAX_VALUE;
        currentPathSum.add(Math.min(first, second));
      }
      pathSum = currentPathSum;
   }

   int minSum = Integer.MAX_VALUE;
    for(int sum : pathSum){
      if ( sum < minSum)
        minSum = sum;
    }
    return minSum;
  }
}
