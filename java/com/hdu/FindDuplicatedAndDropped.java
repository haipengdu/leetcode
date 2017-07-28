package com.hdu;

/**
 * Created by hdu on 6/13/17.
 */
public class FindDuplicatedAndDropped {

  public static void main(String [] args){
    CodeUtil.printObject(new FindDuplicatedAndDropped().findDroppedWithDuplicated(new int[]{2,1,2}));
  }

  public int findDroppedWithDuplicated(int [] nums){
    int a = 0;
    int b = 0;
    int n = nums.length;

    a = n*(n+1)/2;
    b = n*(n+1)*(2*n+1)/6;

    for(int num : nums){
      a = a - num;
      b = b - num * num;
    }

    b = b /a;
    return (b + a)/2;
  }
}
