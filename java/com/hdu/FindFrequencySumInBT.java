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
    //CodeUtil.printObject(new FindFrequencySumInBT().frequencySort("tree"));
    CodeUtil.printObject(new FindFrequencySumInBT().arrayNesting(new int [] {5,4,0,3,1,6,2}));
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

  public List<Integer> topKFrequent(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k == 0)
      return new ArrayList<>();
    Map<Integer, Integer> frequencies = new HashMap<>();
    for(int n : nums)
      frequencies.put(n, frequencies.getOrDefault(n, 0) + 1);

    List<int[]> dataOrders = new ArrayList<>();
    frequencies.forEach( (n, f) -> dataOrders.add(new int[] {f, n}) );
    Collections.sort(dataOrders, (a, b) -> b[0] - a[0]);

    List<Integer> result = new ArrayList<>();
    for(int i = 0; i < dataOrders.size(); i++){
      result.add(dataOrders.get(i)[1]);
      if (result.size() == k)
        break;
    }
    return result;
  }


  public int arrayNesting(int[] nums) {

    if ( nums == null || nums.length == 0 )
      return 0;
    Map<Integer, Integer> nestingLengths = new HashMap<>();
    int max = 0;
    for(int n : nums){
      int current = getNestingLength(nums, n, nestingLengths);
      max = Math.max(current, max);
    }
    return max;
  }

  private int getNestingLength(int [] nums, int pos, Map<Integer, Integer> nestingLengths){
    if ( nestingLengths.get(pos) != null )
      return nestingLengths.get(pos);

    int length = 1;
    int nextPos = nums[pos];
    List<Integer> visitedPositions = new ArrayList<>();
    visitedPositions.add(pos);
    while (pos != nextPos){
      visitedPositions.add(nextPos);
      nextPos = nums[nextPos];
      length++;
    }

    for(int p : visitedPositions)
      nestingLengths.put(p, length);
    return length;
  }
}
