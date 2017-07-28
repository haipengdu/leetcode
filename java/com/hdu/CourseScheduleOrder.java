package com.hdu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by hdu on 7/10/17.
 */
public class CourseScheduleOrder {

  public static void main(String [] args){
    CodeUtil.printArray(new CourseScheduleOrder().findOrder(3,
        new int [][]{{2,0},{2,1}}));
  }
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    if (numCourses == 0 || prerequisites == null  )
      return new int [0];
    List<Integer> orders = new ArrayList<>();

    Map<Integer, Set<Integer>> courseDependencies = new HashMap<>();
    int [] courseDepCounts = new int[numCourses];

    //initialize map
    for(int i = 0; i < numCourses; i++){
      courseDependencies.put(i, new HashSet<>());
    }

    for(int [] dep : prerequisites){
      courseDependencies.get(dep[1]).add(dep[0]);
      courseDepCounts[dep[0]]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    pushNextToQueue(queue, courseDependencies,courseDepCounts);

    while(!queue.isEmpty()){
      int course = queue.poll();
      if (orders.contains(course))
        break;
      orders.add(course);
      decreaseDepsCount(courseDependencies, course,courseDepCounts);
      pushNextToQueue(queue, courseDependencies, courseDepCounts);

    }

    //cannot find the order
    if (orders.size() != numCourses)
      return new int [0];

    int [] result = new int[numCourses];
    for(int index =0; index < numCourses; index++)
      result [index] = orders.get(index);

    return result;
  }

  private void pushNextToQueue(Queue<Integer> queue, Map<Integer, Set<Integer>> courseDependencies,
      int[] courseDepCounts){
    for(int c = 0; c < courseDepCounts.length; c++){
      if (courseDepCounts[c] == 0 ) {
        queue.offer(c);
        courseDepCounts[c] = -1;
        break;
      }
    }
  }

  private void decreaseDepsCount(Map<Integer, Set<Integer>> courseDependencies, Integer removedCourse, int[] courseDepCounts){
    for(Integer course : courseDependencies.get(removedCourse)){
      courseDepCounts[course]--;
    }
    courseDependencies.remove(removedCourse);
  }
}
