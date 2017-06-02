package com.hdu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hdu on 4/16/17.
 */
public class FindWordsInRow {

  private static Map<Character, Integer> charRowsMap = new HashMap<>();

  static{
    char[][] charRows = new char[][]{
        new char[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
        new char[]{'a','s', 'd', 'f', 'g', 'h', 'j', 'k', 'l'},
        new char[]{'z', 'x', 'c', 'v', 'b', 'n', 'm'}
    };

    for(int i =0; i < charRows.length; i++){
      for(int j =0; j < charRows[i].length; j++){
        charRowsMap.put(charRows[i][j], i);
      }
    }
  }

  public static void main(String [] args){
    String [] result = new FindWordsInRow().findWords(
        new String[] {"Hello", "Alaska", "Dad", "Peace"}
    );
    for(String w : result){
      System.out.print(w + " ");
    }
  }
  public String[] findWords(String[] words) {

   List<String> typedWordsInRow = new ArrayList<>();

    for(String word : words){
      int row = -1;
      int pos = 0;
      for(pos =0; pos < word.length(); pos++){
        char c = Character.toLowerCase(word.charAt(pos));
        if (row >=0 && charRowsMap.get(c) != row){
          break;
        }
        row = charRowsMap.get(c);
      }
      if (pos == word.length()){
        typedWordsInRow.add(word);
      }
    }

    String [] result = new String[typedWordsInRow.size()];
    result = typedWordsInRow.toArray(result);
    return result;
  }
}
