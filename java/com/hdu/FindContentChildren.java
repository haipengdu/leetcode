package com.hdu;

import java.util.Arrays;

/**
 * Created by hdu on 4/18/17.
 */
public class FindContentChildren {

  public static void main(String[] args) {

    int[] g = {10,9, 8, 7};
    int[] s = {10, 9, 8, 7, 10, 9, 8, 7};
    CodeUtil.printObject(new FindContentChildren().findContentChildren(g, s));
  }

  public int findContentChildren(int [] g, int [] s){
    if (g == null || s == null || g.length == 0 || s.length == 0) {
      return 0;
    }
    Arrays.sort(g);
    Arrays.sort(s);

    int contentCount = 0;
    int gindex = 0;
    int sindex = 0;

    while (gindex < g.length && sindex < s.length){
      if (g[gindex] <= s[sindex]){
        contentCount++;
        gindex++;
        sindex++;
      } else{
        sindex++;
      }
    }
    return contentCount;
  }
  public int findContentChildren3(int[] g, int[] s) {

    if (g == null || s == null || g.length == 0 || s.length == 0) {
      return 0;
    }

    int[][] contents = new int[s.length][g.length];

    for (int i = 0; i < s.length; i++) {
      contents[i][0] = s[i] >= g[0] ? 1 : 0;
    }

    for (int j = 1; j < g.length; j++) {
      for (int i = 0; i < s.length; i++) {
        int contentBefore = contents[i][j-1];
        int contentCurrent = 0;
        for( int k =0 ; k < s.length; k++){
          if ( k == i ){
            continue;
          }
          if (s[k] >= g[j]){
                  contentCurrent = 1;
            break;
          }
        }
        if (contentBefore + contentCurrent == g.length){
          return g.length;
        }
        contents[i][j] = contentBefore + contentCurrent;
      }
    }

    int maxContent = 0;
    for( int i =0; i < contents.length; i++){
      if (contents[i][g.length -1] > maxContent)
        maxContent = contents[i][g.length -1];
    }
    return maxContent;
  }

  public int findContentChildren2(int[] g, int[] s) {

    Arrays.sort(g);
    Arrays.sort(s);
    int i = 0;
    for(int j=0;i<g.length && j<s.length;j++) {
      if(g[i]<=s[j]) i++;
    }
    return i;
  }
}
