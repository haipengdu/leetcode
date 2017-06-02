package com.hdu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hdu on 5/8/17.
 */
public class FindAllCombination {


  public static void main(String [] args){
    String s = "app.any.com";
    //System.out.println(new FindAllCombination().getCombination(s));
   // new FindAllCombination().printCombineProduct(4);
    new FindAllCombination().printFactor(12, 12, "");
  }

  public List<String> getCombination(String s){
    List<String> res=new ArrayList<>();
    if(s==null || s.length()==0) return res;
    helper(s, 0, new String(), res);
    return res;
  }

  private void helper(String s, int pos, String path, List<String> result){
    // touch the end
    if ( pos >= s.length()){
      result.add(path);
      return;
    }

    StringBuilder currentPath = new StringBuilder(path);
    while(pos < s.length() && s.charAt(pos) != '[')
      currentPath.append(s.charAt(pos++));

    if (pos < s.length() && s.charAt(pos) == '['){
      int endPos = pos + 1;
      while (s.charAt(endPos) != ']')
        endPos++;
      String [] items = s.substring(pos+1, endPos).split(",");

      for(String item : items){
        helper(s, endPos+1, currentPath.toString() + item, result);
      }
    }else
      result.add(currentPath.toString());

  }

  public void printFactor(int num, int pos, String path){
    if ( num == 1 ){
      if ( path.indexOf('*') < 0)
        path += "*1";
      System.out.println(path);
      return;
    }


    for(int i = pos; i > 1 ; i--){
      if ( num % i == 0 ){
        String nextPath = path;
        if (nextPath.length() > 0 )
          nextPath += "*";
        nextPath += (i);
        printFactor(num/i, i, nextPath);
      }
    }
  }

  public void printCombineProduct(int target){
    if(target<1) return;
    dfs(target, target, "");
  }

  public void dfs(int target, int pos, String path){
    if(target<1) return;
    if(target==1){
      if(!path.contains("*")) path+="*1";
      System.out.println(path);
    }
    for(int i=pos; i>1; i--){
      if(target%i==0) dfs(target/i, i, path.isEmpty()?path+i:path+"*"+i); //note, valid output is only target/i>i
    }
  }
}
