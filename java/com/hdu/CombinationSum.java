package com.hdu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by hdu on 6/22/17.
 */
public class CombinationSum {
  public static void main(String [] args){
    //CodeUtil.printObject(new CombinationSum().combinationSum(new int [] {2,3,7}, 7));
    CodeUtil.printObject(new CombinationSum().combinationSum2(new int [] {10,1,2,7,6,1,5}, 8));
  }
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);

    //should ask if candidates can have 0 or not,
    // if contains 0, result is unlimit, remove 0 from candidates to avoid the problem
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    getResult(result, new ArrayList<Integer>(), candidates, target, 0);

    return result;
  }

  private void getResult(List<List<Integer>> result, List<Integer> currentCombination, int[] candidates, int target, int start){

    if (target == 0){
      result.add(new ArrayList<>(currentCombination));
      return;
    }

    for(int i =start; i < candidates.length; i++){
      int number = candidates[i];
      if ( target >= number){
        currentCombination.add(number);
        getResult(result, currentCombination, candidates, target - number, i);
        currentCombination.remove(currentCombination.size() - 1);
      }
    }
  }


  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(candidates);
    travelAllConbinations(candidates, 0, target, result, new ArrayList<>());
    return result;
  }

  private void travelAllConbinations(int [] candidates, int start, int target,
      List<List<Integer>> result, List<Integer> currentCombination ){
    if (target == 0){
      result.add(new ArrayList<>(currentCombination));
      return;
    }

    for(int i =start; i < candidates.length; i++){
      int number = candidates[i];
      if ( i > start && number == candidates[i-1])
        continue;
      if ( target >= number ){
        currentCombination.add(number);
        travelAllConbinations(candidates, i + 1, target - number, result, currentCombination);
        currentCombination.remove(currentCombination.size() - 1);
      }
    }
  }
}
