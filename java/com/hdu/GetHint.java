package com.hdu;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hdu on 6/23/17.
 */
public class GetHint {

  public String getHint(String secret, String guess) {

    int bullCount  = 0;
    Map<Character, Integer> secretCounts = new HashMap<>();
    Map<Character, Integer> guessCount = new HashMap<>();

    for(int i =0; i < secret.length(); i++){
      char sc = secret.charAt(i);
      char gc = guess.charAt(i);
      if ( sc == gc)
        bullCount++;
      secretCounts.put(sc, secretCounts.getOrDefault(sc, 0) + 1);
      guessCount.put(gc, guessCount.getOrDefault(gc, 0) + 1);
    }

    int cowCount = 0 - bullCount;
    for(char c : secretCounts.keySet()){
      cowCount += Math.min(secretCounts.get(c).intValue(), guessCount.getOrDefault(c, 0));
    }

    return String.format("%dA%dB", bullCount, cowCount);
  }


}
