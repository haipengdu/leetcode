package com.hdu;

import com.sun.org.apache.bcel.internal.classfile.Code;

/**
 * Created by hdu on 4/24/17.
 */
public class ShortestPath {

  public static void main(String[] args) {
        /* Let us create the example graph discussed above */
    int graph[][] = new int[][]{
        {0, 4, 0, 0, 0, 0, 0, 8, 0},
        {4, 0, 8, 0, 0, 0, 0, 11, 0},
        {0, 8, 0, 7, 0, 4, 0, 0, 2},
        {0, 0, 7, 0, 9, 14, 0, 0, 0},
        {0, 0, 0, 9, 0, 10, 0, 0, 0},
        {0, 0, 4, 14, 10, 0, 2, 0, 0},
        {0, 0, 0, 0, 0, 2, 0, 1, 6},
        {8, 11, 0, 0, 0, 0, 1, 0, 7},
        {0, 0, 2, 0, 0, 0, 6, 7, 0}
    };

    int graph2 [][] = new int [][] {
        {0, 4},
        {4, 0}
    };
    ShortestPath t = new ShortestPath();
    int [] verifiedDistance = t.dijkstra(graph, 0);
    int [] myDistance = t.dijkstraMe(graph, 0);

    CodeUtil.printArray(verifiedDistance);
    CodeUtil.printArray(myDistance);
  }



  private int [] dijkstraMe(int[][] graph, int src) {

    int dist [] = new int[graph.length];
    boolean [] visited = new boolean[graph.length];

    for(int v =0; v < graph.length; v++){
        dist[v] = Integer.MAX_VALUE;
        visited[v] = false;
    }
    dist[src] = 0;

    for(int v = 0; v < graph.length - 1; v++){
      int u = minDistanceIndex(dist, visited);

      visited[u] = true;
      for(int k = 0; k < graph.length; k++){
        if ( !visited[k] && graph[u][k] != 0 && dist[u] != Integer.MAX_VALUE &&
            dist[u] + graph[u][k] < dist[k]){
          dist[k] = dist[u] + graph[u][k];

        }
      }
    }
    return dist;
  }

  int minDistanceIndex(int [] dist, boolean [] visit){
    int min = Integer.MAX_VALUE;
    int index = -1;
    for(int i =0; i < dist.length; i++){
      if (!visit[i] && dist[i] <= min){
        min = dist[i];
        index = i;
      }
    }
    return index;
  }
  int [] dijkstra(int graph[][], int src)
  {
    int V = graph.length;
    int dist[] = new int[V]; // The output array. dist[i] will hold
    // the shortest distance from src to i

    // sptSet[i] will true if vertex i is included in shortest
    // path tree or shortest distance from src to i is finalized
    Boolean sptSet[] = new Boolean[V];

    // Initialize all distances as INFINITE and stpSet[] as false
    for (int i = 0; i < V; i++)
    {
      dist[i] = Integer.MAX_VALUE;
      sptSet[i] = false;
    }

    // Distance of source vertex from itself is always 0
    dist[src] = 0;

    // Find shortest path for all vertices
    for (int count = 0; count < V-1; count++)
    {
      // Pick the minimum distance vertex from the set of vertices
      // not yet processed. u is always equal to src in first
      // iteration.
      int u = minDistance(dist, sptSet);

      // Mark the picked vertex as processed
      sptSet[u] = true;

      // Update dist value of the adjacent vertices of the
      // picked vertex.
      for (int v = 0; v < V; v++)

        // Update dist[v] only if is not in sptSet, there is an
        // edge from u to v, and total weight of path from src to
        // v through u is smaller than current value of dist[v]
        if (!sptSet[v] && graph[u][v]!=0 &&
            dist[u] != Integer.MAX_VALUE &&
            dist[u]+graph[u][v] < dist[v])
          dist[v] = dist[u] + graph[u][v];
    }

    // print the constructed distance array
    return dist;
  }

  int minDistance(int dist[], Boolean sptSet[])
  {
    int V = dist.length;
    // Initialize min value
    int min = Integer.MAX_VALUE, min_index=-1;

    for (int v = 0; v < V; v++)
      if (sptSet[v] == false && dist[v] <= min)
      {
        min = dist[v];
        min_index = v;
      }

    return min_index;
  }

}
