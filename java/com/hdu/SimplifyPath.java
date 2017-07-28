package com.hdu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by hdu on 6/27/17.
 */
public class SimplifyPath {

  public static void main(String [] args){
    System.out.println(new SimplifyPath().simplifyPath("/a/./b/../../c/"));
  }
  public String simplifyPath(String path) {
    Set<String> skipItems = new HashSet<>(Arrays.asList(".", "..", ""));
    Stack<String> stack = new Stack<>();
    for(String dir : path.split("/") ){
      if (!skipItems.contains(dir))
        stack.push(dir);
      if ("..".equals(dir) && !stack.isEmpty())
        stack.pop();
    }
    if (stack.isEmpty())
      return "/";
    StringBuilder sb = new StringBuilder();
    while(!stack.isEmpty()){
      sb.insert(0, "/"+stack.pop());
    }
    return sb.toString();
  }
}
