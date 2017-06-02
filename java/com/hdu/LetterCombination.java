package com.hdu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hdu on 5/1/17.
 */
public class LetterCombination {


  public static void main(String [] args){
    CodeUtil.printObject(new LetterCombination().letterCombinations(""));
  }

  static Map<Character, List<Character>> digitLetterMap = new HashMap<>();
  static{
    digitLetterMap.put('0', Arrays.asList('0'));
    digitLetterMap.put('1', Arrays.asList('1'));
    digitLetterMap.put('2', Arrays.asList('a', 'b', 'c'));
    digitLetterMap.put('3', Arrays.asList('d', 'e', 'f'));
    digitLetterMap.put('4', Arrays.asList('g', 'h', 'i'));
    digitLetterMap.put('5', Arrays.asList('j', 'k', 'l'));
    digitLetterMap.put('6', Arrays.asList('m', 'n', 'o'));
    digitLetterMap.put('7', Arrays.asList('p', 'q', 'r', 's'));
    digitLetterMap.put('8', Arrays.asList('t', 'u', 'v'));
    digitLetterMap.put('9', Arrays.asList('w', 'x', 'y', 'z'));
  }


  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    if (digits == null || digits.length() == 0)
      return result;
    findLetterCombinations(digits, 0, new ArrayList<>(), result);
    return result;
  }

  public void findLetterCombinations(String digits, int index, List<Character> currentConbinations, List<String> combinations){
    if (index >= digits.length() ){
      StringBuilder sb = new StringBuilder();
      currentConbinations.forEach(c -> sb.append(c));
      combinations.add(sb.toString());
      return;
    }

    List<Character> currentList = digitLetterMap.get(digits.charAt(index));
    for(Character c : currentList){
        currentConbinations.add(c);
        findLetterCombinations(digits, index+1, currentConbinations, combinations);
        currentConbinations.remove(currentConbinations.size()-1);
    }
  }
}
