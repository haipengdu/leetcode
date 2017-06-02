package com.hdu;

/**
 * Created by hdu on 4/15/17.
 */
public class FindComplement {

  public static void main(String [] args){
    System.out.println(new FindComplement().findComplement(0));
    System.out.println(new FindComplement().findComplement2(0));
  }

  public int findComplement(int num) {

    int mask = 1;
    int result = 0;
    int pos = 0;

    while(true){
     result = result | ( ( 1 ^ ( num & mask )) << pos );
      num = num >> 1;
      if ( num == 0 ){
        break;
      }
      pos++;
    }

    return result;

  }

  public int findComplement2(int num){
    int mask = 1;
    int result = 0;
    int pos = 0;

    while(true){
      result = result | ( ( mask ^ ( num & mask) ) << pos);
      num = num >> 1;
      if ( num == 0 )
        break;
      pos++;
    }

    return result;
  }
}
