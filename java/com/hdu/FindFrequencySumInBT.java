package com.hdu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by hdu on 6/1/17.
 */
public class FindFrequencySumInBT {

  public static void main(String [] args){
    CodeUtil.printObject(new FindFrequencySumInBT().frequencySort("tree"));
  }
  public int[] findFrequentTreeSum(TreeNode root) {
    Map<Integer, Integer> sumFrequency = new HashMap<>();
    travelTreeSum(root, sumFrequency);
    int mostFrequency = 0;
    for(int f : sumFrequency.values())
      mostFrequency = Math.max(mostFrequency, f);
    List<Integer> resultList = new ArrayList<>();
    for(Entry<Integer, Integer> entry : sumFrequency.entrySet()){
      if ( entry.getValue() == mostFrequency)
        resultList.add(entry.getKey());
    }
    int [] sums = new int[resultList.size()];
    for(int i =0; i < resultList.size(); i++)
      sums[i] = resultList.get(i);
    return sums;
  }

  public int travelTreeSum(TreeNode root, Map<Integer, Integer> sumFrequency) {
    if ( root == null )
      return 0;
    int left = travelTreeSum(root.left, sumFrequency);
    int right = travelTreeSum(root.right, sumFrequency);
    int sum = left + right + root.val;
    sumFrequency.put(sum, sumFrequency.getOrDefault(sum, 0) + 1);
    return sum;
  }

  public String frequencySort(String s) {
    if ( s == null || s.length() < 2 )
      return s;
    Map<Character, Integer> frequency = new HashMap<>();
    for(char c : s.toCharArray())
      frequency.put(c, frequency.getOrDefault(c, 0) + 1);

    List<int[]> dataOrders = new ArrayList<>();
    frequency.forEach( (c, f) -> dataOrders.add(new int[] {f, c}) );
    Collections.sort(dataOrders, (a, b) -> b[0] - a[0]);
    StringBuilder sb = new StringBuilder();

    for(int [] data : dataOrders){
      char c = (char)data[1];
      int f = data[0];
      for(int i =0; i < f; i++)
        sb.append(c);
    }
    return sb.toString();
  }
}
