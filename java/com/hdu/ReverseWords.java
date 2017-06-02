package com.hdu;

/**
 * Created by hdu on 4/15/17.
 */
public class ReverseWords {

  public static void main(String [] args){
    System.out.println(new ReverseWords().reverseWords("abc"));
    System.out.println(new ReverseWords().reverseWords2("abc"));
  }
  public String reverseWords(String s) {
    if (s == null || s.length() < 2){
      return s;
    }

    StringBuffer result = new StringBuffer();

    int pos = 0;

    for( int i =0; i < s.length(); i++){
      if (s.charAt(i) == ' '){
        result.append(" ");
        pos = result.length();
      }else {
        result.insert(pos, s.charAt(i));
      }
    }

    return result.toString();
  }


  public String reverseWords2(String s){

    if ( s == null || s.length() == 0 )
      return s;
    StringBuilder result = new StringBuilder();
    StringBuilder buffer = new StringBuilder();
    for(int i =0; i < s.length(); i++){
      if (s.charAt(i) == ' '){
        result.append(buffer.toString());
        result.append(s.charAt(i));
        buffer = new StringBuilder();
      }else{
        buffer.insert(0, s.charAt(i));
      }
    }
    if (buffer.length() > 0)
      result.append(buffer);
    return result.toString();
  }
}
