package com.hdu;

/**
 * Created by hdu on 7/8/17.
 */
public class Tree2Str {

  public String tree2str(TreeNode t) {
    if ( t == null )
      return "";
    StringBuilder sb = new StringBuilder("" + t.val);
    String left = tree2str(t.left);
    String right = tree2str(t.right);
    if (left.length() == 0 && right.length() == 0 )
      return sb.toString();

    else if (right.length() > 0) {
      sb.append("(").append(left).append(")");
      sb.append("(").append(right).append(")");
    }else {
      sb.append("(").append(left).append(")");
    }
    return sb.toString();
  }

  public boolean judgeSquareSum(int c) {

    int from = (int)Math.floor(Math.sqrt(c));
    if ( from * from == c )
      return true;
    int left  = 0;
    int right = from;

    while (left <= right){
      int sum = left*left + right*right;
      if ( sum == c)
        return true;
      if ( sum < c )
        left++;
      if ( sum > c )
        right--;
    }
    return false;
  }
}
