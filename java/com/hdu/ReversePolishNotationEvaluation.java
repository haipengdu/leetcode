package com.hdu;

import java.util.Stack;

/**
 * Created by hdu on 7/8/17.
 */
public class ReversePolishNotationEvaluation {

  public int evalRPN(String[] tokens) {

    int result = 0;
    Stack<Integer> numbers = new Stack<>();

    for (String s : tokens) {
      switch (s) {
        case "+":
          result = numbers.pop() + numbers.pop();
          break;
        case "-":
          result = -(numbers.pop() - numbers.pop());
          break;
        case "*":
          result = numbers.pop() * numbers.pop();
          break;
        case "/":
          int int1 = numbers.pop();
          int int2 = numbers.pop();
          result = int2 / int1;
          break;
        default:
          result = Integer.valueOf(s);
      }
      numbers.push(result);
    }
    return numbers.pop();
  }
}
