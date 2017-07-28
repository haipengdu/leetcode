package com.hdu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hdu on 4/17/17.
 */
public class CodeUtil {

  private static final String breaker = ">>>>>>>>>>";

  public static void printArray(Object[] result) {
    long t = System.currentTimeMillis();
    System.out.println(breaker);
    if (result == null) {
      System.out.println("null");
    } else {
      for (Object r : result) {
        System.out.print(r + " ");
      }
      System.out.println();
    }
    System.out.println(breaker + " cost : " + (System.currentTimeMillis() - t) );
  }


  public static void printArray(int[] result) {
    long t = System.currentTimeMillis();
    System.out.println(breaker);
    if (result == null) {
      System.out.println("null");
    } else {
      for (Object r : result) {
        System.out.print(r + " ");
      }
      System.out.println();
    }
    System.out.println(breaker + " cost : " + (System.currentTimeMillis() - t) );
  }

  public static void printMatrix(int[][] result) {
    long t = System.currentTimeMillis();
    System.out.println(breaker);
    if (result == null) {
      System.out.println("null");
    } else {
      for (int[] r : result) {
        System.out.println(Arrays.toString(r));
      }
      System.out.println();
    }
    System.out.println(breaker + " cost : " + (System.currentTimeMillis() - t) );
  }

  public static void printObject(Object o) {
    long t = System.currentTimeMillis();
    System.out.println(breaker);
    if (o == null) {
      System.out.println("null");
    } else {
      System.out.println(o);
    }
    System.out.println(breaker + " cost : " + (System.currentTimeMillis() - t) );
  }

  public static void printList(ListNode root) {
    long t = System.currentTimeMillis();
    System.out.println(breaker);
    if (root == null) {
      System.out.println("null");
    } else {
      ListNode node = root;
      while(node != null){
        System.out.print(node.val + " ");
        node = node.next;
      }
      System.out.println();
    }
    System.out.println(breaker + " cost : " + (System.currentTimeMillis() - t) );
  }

  public static void printTree(TreeNode root){
    if (root == null){
      System.out.println("null");
      return;
    }
    Queue<Object[]> queues = new LinkedList<>();
    queues.offer(new Object[]{0, 0 , root});

    int lastLevel = -1;
    int lastPos = 0;

    int maxLevel = 3;
    int width = (int) (4 * (Math.round(Math.pow(2, maxLevel)) - 1) + Math.round(Math.pow(2, maxLevel))) ;
    int nextLinePadding = width / 2;
    int interval = 0;
    while(!queues.isEmpty()){
      Object[] data = queues.poll();
      int currentLevel = (Integer)data[0];
      int pos = (Integer)data[1];
      TreeNode node = (TreeNode) data[2];

      if (currentLevel != lastLevel){

        System.out.println();
        lastLevel = currentLevel;

        System.out.print(getPadding(nextLinePadding));
        nextLinePadding = nextLinePadding - (int)Math.round(Math.pow(2, maxLevel - currentLevel));
        interval = 4 * (maxLevel - currentLevel + 1);

      }
      if (pos != Math.round(Math.pow(2, currentLevel)) - 1) {
        for (int p = lastPos; p < pos; p++) {
          if (p != Math.round(Math.pow(2, currentLevel)) -2)
            System.out.print(getPadding(interval - currentLevel - 1));
          if (p != pos - 1) {
            System.out.print(" ");
          }
        }
      }
      lastPos = pos;
      System.out.print(node.val);
      if (node.left != null){
        queues.offer(new Object[]{currentLevel + 1, 2*pos + 1, node.left} );
      }
      if (node.right != null){
        queues.offer(new Object[]{currentLevel + 1, 2*pos + 2, node.right} );
      }
    }

  }


  private static String getPadding(int count){
    StringBuilder sb = new StringBuilder();
    for(int i =0; i < count; i++)
      sb.append(" ");
    return sb.toString();
  }


  private static int getMaxLevel(TreeNode node){
    if (node == null)
      return 0;
    return Math.max(getMaxLevel(node.left), getMaxLevel(node.right)) + 1;
  }
}
