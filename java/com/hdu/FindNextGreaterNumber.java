package com.hdu;

/**
 * Created by hdu on 4/16/17.
 */
public class FindNextGreaterNumber {

  public static void main(String [] args){

    int [] result = new FindNextGreaterNumber().nextGreaterElement(new int[]{2,4},
        new int[] {1,2,3,4});

    for(int r : result){
      System.out.print(r + " ");
    }
  }

  public int[] nextGreaterElement(int[] findNums, int[] nums) {
    if (findNums == null || findNums.length == 0 ){
      return new int[0];
    }
    int [] result = new int[findNums.length];
    for(int i = 0; i < findNums.length; i++){
      boolean getNumber = false;
      int j;
      for( j =0; j < nums.length; j++){
        if (getNumber && nums[j] > findNums[i]){
          result[i] = nums[j];
          break;
        }

        if (nums[j] == findNums[i]){
          getNumber = true;
        }
      }

      if ( j == nums.length ){
        result[i] = -1;
      }
    }
    return result;
  }
}
