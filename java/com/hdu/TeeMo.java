package com.hdu;

/**
 * Created by hdu on 6/1/17.
 */
public class TeeMo {

  public static void main(String[] args) {
    CodeUtil.printObject(new TeeMo().findPoisonedDuration(new int[]{1, 2, 3}, 2));
  }

  public int findPoisonedDuration(int[] timeSeries, int duration) {
    if (timeSeries == null || timeSeries.length == 0) {
      return 0;
    }
    int totalDuration = 0;
    int timeToWake = 0;

    for (int i = 0; i < timeSeries.length; i++) {
      int timeDiffToWake = timeSeries[i] - timeToWake;
      if (timeSeries[i] >= timeToWake) {
        totalDuration += duration;
        timeToWake = timeSeries[i] + duration;
      } else {
        int timeDiff = timeToWake - timeSeries[i];
        if (timeDiff <= duration) {
          totalDuration += (duration - timeDiff);
          timeToWake += (duration - timeDiff);
        }
      }
    }

    return totalDuration;
  }
}
