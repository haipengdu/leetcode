package com.hdu;

/**
 * Created by hdu on 4/17/17.
 */
public class CanWinNim {

  public boolean canWinNim(int n) {
    if ( n <= 3 )
      return true;

    boolean win1 = true;
    boolean win2 = true;
    boolean win3 = true;

    for( int i = 4; i <= n; i++){
      boolean canWin = !(win1 && win2 && win3);
      win1 = win2;
      win2 = win3;
      win3 = canWin;
    }
    return win3;
  }
}
