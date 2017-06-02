package com.hdu;

/**
 * Created by hdu on 5/7/17.
 */
public class KDArraySum {

  public int sum(KDArray m) {
    return sum(m, new int[]{});
  }



  public int sum(KDArray m, int[] pos) {
    Object element = m.get(pos);

    int sum = 0;
    if (element instanceof Integer){
      return (int) m.get(pos);
    }else{
      int length = m.getLength(pos);
      int[] nextPos = new int[pos.length + 1];
      System.arraycopy(pos, 0, nextPos, 0, pos.length);
      for( int i =0;i <length; i++){
        nextPos[nextPos.length-1] = i;
        sum += sum(m, nextPos);
      }
    }
    return sum;
  }

  private class KDArray {

    public Object get(int[] pos) {
      return 1;
    }

    public int getLength(int [] pos){
      return 0;
    }
  }
}
