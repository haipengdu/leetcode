package com.hdu;

/**
 * Created by hdu on 6/22/17.
 */
public class SortColor {

  public static void main(String[] args){
    int [] a = new int[] { 0,1,0,2,1};
    new SortColor().sortColors(a, a.length);
    CodeUtil.printArray(a);
  }
  //can be used for as many as possible colors
  public void sortColors(int a[], int n){
    if ( a == null || a.length <= 1){
      return;
    }

    int index = sortWithTarget(a, 0, 0);
    sortWithTarget(a, index, 1);
  }

  private int sortWithTarget(int [] a, int start, int target){
    int index = start;
    while (index < a.length){
      while(index < a.length && a[index] == target )
        index++;
      int swapIndex = index+1;
      while (swapIndex < a.length && a[swapIndex] != target)
        swapIndex++;
      if ( swapIndex >= a.length )
        break;
      swap(a, index, swapIndex);
      index++;
    }
    return index;
  }
  private void swap(int [] a, int i, int j){
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }
}
