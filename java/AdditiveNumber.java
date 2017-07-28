/**
 * Created by hdu on 7/10/17.
 */
public class AdditiveNumber {
  public boolean isAdditiveNumber(String num) {
    if ( num == null  || num.length() <= 2 )
      return true;
    return isAdditiveNumber(num, 2);
  }

  private boolean isAdditiveNumber(String num, int index) {
    if (index == num.length() )
      return true;
    return false;
  }
}
