package com.hdu;

/**
 * Created by hdu on 4/25/17.
 */
public class SimplfyFormula {


  public static void main(String [] args){
    SimplfyFormula sf = new SimplfyFormula();
    CodeUtil.printObject(sf.removeParenthesis('-', "a-(3b-(4+2a-(5-6b)))"));
  }

  private String removeParenthesis(char sign, String str){
    if (str.indexOf('(') < 0 && str.indexOf(')') < 0){
      return str;
    }
    StringBuilder sb = new StringBuilder();


    for(int i =0; i < str.length(); i++){
      if (str.charAt(i) == '('){
        char currentSign = '+';
        if (i > 0) {
          currentSign = str.charAt(i - 1);
        }
        int matchedPos = findMatchedPos(str, i);
        String removedParenthesis = removeParenthesis(currentSign, str.substring(i+1, matchedPos));
        if (currentSign == '-')
          removedParenthesis = reverseSign(removedParenthesis);
        sb.append(removedParenthesis);
        i = matchedPos+1;
      }else
        sb.append(str.charAt(i));
    }
    return sb.toString();
  }

  private String reverseSign(String str) {
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < str.length(); i++){
      char c = str.charAt(i);
      if ( c == '+')
        c = '-';
      else if ( c == '-')
        c = '+';
      sb.append(c);
    }
    return sb.toString();
  }

  private int findMatchedPos(String str, int i) {
    boolean touchRight = false;
    int leftCount = 0;
    for(int pos = i; pos < str.length(); pos++){
      if (str.charAt(pos) == '(')
        leftCount++;
      else if (str.charAt(pos) == ')')
        leftCount--;
      if (leftCount == 0)
        return pos;
    }
    throw new IllegalArgumentException("wrong format");
  }

}
