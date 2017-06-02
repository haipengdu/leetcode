package com.hdu;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hdu on 5/7/17.
 */
public class InsertInterval {

  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    if (intervals == null || intervals.isEmpty())
      return Arrays.asList(newInterval);
    List<Interval> result = new ArrayList<>();

    for(Interval i : intervals){
      if (newInterval == null || i.end < newInterval.start){
        result.add(i);
      }else if (newInterval.end < i.start){
        result.add(newInterval);
        result.add(i);
        newInterval = null;
      }else{
        newInterval.start = Math.min(newInterval.start, i.start);
        newInterval.end = Math.max(newInterval.end, i.end);
      }
    }

    if (newInterval != null)
      result.add(newInterval);

    return result;
  }
}
