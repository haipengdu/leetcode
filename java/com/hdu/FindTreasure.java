package com.hdu;

/**
 * Created by hdu on 5/2/17.
 */
public class FindTreasure {


  public static void main(String [] args){
    char [][] maps = new char[][]{
        {' ', ' '},
        {' ', ' '}
    };

    int [] result = findTreasure(maps, 5);

    System.out.println(result[0] + " " + result[1]);
  }

  public static int [] findTreasure(char[][] maps, int health){
    return findTreasure(maps, 0, 0, 0, health);
  }

  private static int[] findTreasure(char[][] maps, int x, int y, int steps, int health) {
    if (steps >= maps.length * 2)
      return new int []{ -1, health};
    if (x < 0 || x >= maps.length ||
        y < 0 || y >= maps.length)
      return new int[] { -1, health};

    char c = maps[x][y];
    if (c == 'X'){
      return new int[] { -1, health};
    }

    if (c == 'T'){
      return new int [] {steps, health};
    }

    int trap = 0;
    if ( c >= '0' && c <= '9'){
      trap = c - '0';
      if (health - trap <= 0 )
        return new int[] { -1, health};
    }

    int [] result = new int []{maps.length*2+1, 0};

    int [] resultNext = findTreasure(maps, x -1, y, steps+1, health - trap);

    //if (resultNext[0] > 0 && resultNext[1] > result[1])
      //result = resultNext;
    if (resultNext[0] > 0)
      return resultNext;
    resultNext = findTreasure(maps, x+1, y, steps+1, health - trap);

    //if (resultNext[0] > 0 && resultNext[1] > result[1])
    //result = resultNext;
    if (resultNext[0] > 0)
      return resultNext;

    resultNext = findTreasure(maps, x, y-1, steps+1, health - trap);

//if (resultNext[0] > 0 && resultNext[1] > result[1])
    //result = resultNext;
    if (resultNext[0] > 0)
      return resultNext;

    resultNext = findTreasure(maps, x, y+1, steps+1, health - trap);

    //if (resultNext[0] > 0 && resultNext[1] > result[1])
    //result = resultNext;
    if (resultNext[0] > 0)
      return resultNext;

    return new int[]{-1, health};
  }

  public static void printResult(int [] result){
    System.out.println(result[0] + " " + result[1]);
  }
}
