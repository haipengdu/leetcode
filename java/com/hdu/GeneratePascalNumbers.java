package com.hdu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hdu on 5/23/17.
 */
public class GeneratePascalNumbers {

  public static void main(String [] args){
    CodeUtil.printObject(new GeneratePascalNumbers().generate2(0));
    CodeUtil.printObject(new GeneratePascalNumbers().countSegments("Hello, my name is John"));
  }
  public List<List<Integer>> generate(int numRows) {
    if (numRows <= 0 )
      return new ArrayList<>(1);
    List<List<Integer>>  numbers = new ArrayList<>();
    numbers.add(Arrays.asList(1));
    if ( numRows == 1)
      return numbers;

    List<Integer> lastRow = numbers.get(0);
    for(int i = 2; i <= numRows; i++){
      List<Integer> currentRow = generateFromLast(lastRow);
      currentRow.add(0, 1);
      currentRow.add(1);
      numbers.add(currentRow);
      lastRow = currentRow;
    }

    return numbers;
  }

  private List<Integer> generateFromLast(List<Integer> lastRow) {
    List<Integer> nextRow = new ArrayList<>();
    for(int i =0; i <lastRow.size()-1;i++ ){
      nextRow.add(lastRow.get(i) + lastRow.get(i+1));
    }
    return nextRow;
  }

  public List<Integer> generate2(int numRows){
    if (numRows <= 0 )
      return Arrays.asList(1);
    List<Integer>  numbers = new ArrayList<>();
    numbers.add(1);
    if ( numRows == 1)
      return numbers;
    numbers.add(1);
    if (numRows == 2)
      return numbers;

    for(int i = 1 ; i < numRows - 1; i++){
      int last = numbers.get(0);
      for( int j = 1; j <= i; j++){
        int d = numbers.get(j);
        if ( j == i )
          numbers.set(j, last + 1);
        else
          numbers.set(j, numbers.get(j) + last);

        last = d;
      }
      numbers.add(1);
    }
    return numbers;
  }


  public int countSegments(String s) {
    if ( s == null || s.length() == 0 )
      return 0;
    int count = 0;
    boolean isSegment = false;
    for(int i =0; i < s.length(); i++){
      if ( s.charAt(i) != ' ')
      isSegment = true;
      if ( s.charAt(i) == ' ' || i == s.length() -1){
        if (isSegment)
          count++;
        isSegment = false;
      }
    }
    return count;
  }

  public boolean isBalanced(TreeNode root) {
    Object[] result = balanceWithLevel(root);
    return (boolean)result[1];

  }

  private Object[] balanceWithLevel(TreeNode root){
    if (root == null)
      return new Object[]{0, true};
    Object[] left = balanceWithLevel(root.left);
    if (!(boolean)left[1])
      return left;
    Object[] right = balanceWithLevel(root.right);
    if (!(boolean)right[1])
      return right;
    int leftLevel = (int)left[0];
    int rightLevel = (int)right[0];
    return new Object[]{ Math.max(leftLevel, rightLevel) + 1, Math.abs(leftLevel-rightLevel) <= 1};
  }
}
