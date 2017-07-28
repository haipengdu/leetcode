package com.hdu;

/**
 * Created by hdu on 6/28/17.
 */
public class FindKthElementInArray {

  public static void main(String [] args){
    int[] nums = new int [] {10,13,4,8,12,5,19};
    new FindKthElementInArray().findKthElementInArray(nums, 5);
    CodeUtil.printArray(nums);
  }
  public int findKthElementInArray(int [] nums, int k){
    int index = findKthInArray(nums, k, 0, nums.length - 1);
    System.out.println(index + " " +nums[index-1]);
    return nums[index-1];
  }

  private int findKthInArray(int[] nums, int k, int start, int end) {
    if ( start == end )
      return start;
    int pivot = nums[start];
    int left = start + 1;
    int right = end;
    while (left < right){
      while(nums[left] < pivot) left++;
      while(nums[right] > pivot) right--;
      if ( left < right)
        swap(nums, left, right);
    }
    //left is the first bigger than pivot
    swap(nums, left-1, start);
    if ( k == left - start )
      return left ;
    if ( k < left )
      return findKthInArray(nums, k, 0, left-1);
    return findKthInArray(nums, k - left , left , end);
  }

private   void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }

}
