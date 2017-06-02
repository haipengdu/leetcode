package com.hdu;

/**
 * Created by hdu on 6/1/17.
 */
public class FindFriendCircle {

  public int findCircleNum(int[][] m) {
    if ( m == null || m.length == 0 )
      return 0;
    boolean [] visited = new boolean[m.length];
    int count = 0;
    for(int i =0; i < visited.length; i++){
      if ( visited[i])
        continue;
      visited[i] = true;
      count++;
      visitAllFriends(m, i, visited);
    }
    return count;
  }

  private void visitAllFriends(int[][] m, int i, boolean[] visited) {
    for(int col = 0; col < m.length; col++){
      if (i == col || m[i][col] == 0 || visited[col])
        continue;
      visited[col] = true;
      visitAllFriends(m, col, visited);
    }
  }
}
