package com.hdu;

/**
 * Created by hdu on 5/30/17.
 */
public class BattleShip {

  public int countBattleships(char[][] board) {
    if ( board == null || board.length == 0 )
      return 0;
    int count = 0;
    for(int r = 0; r < board.length; r++){
      for(int c = 0; c < board[r].length;c++){
        if (board[r][c] != 'X')
          continue;
        boolean isTopShip = r - 1 < 0 || board[r-1][c] != 'X' ? false : true;
        boolean isLeftShip = c -1 < 0 || board[r][c-1] != 'X' ? false : true;
        if (!(isLeftShip || isTopShip))
          count++;
      }
    }
    return count;
  }
}
