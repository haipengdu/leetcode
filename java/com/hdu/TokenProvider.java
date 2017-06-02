package com.hdu;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.stream.IntStream;

/**
 * Created by hdu on 4/25/17.
 */
public class TokenProvider {

  private Timer fillBucketTimer;
  private Queue<String> tokenBucket;
  private int tokenCount;
  private int tokenLimit = 20;
  private long fillTokenInterval = 500;
  private boolean inService;

  public String getToken() throws IllegalAccessException {
    if (!inService)
      throw new IllegalAccessException("Token provider is not in service");
    synchronized (this){
      if (tokenCount <= 0)
        throw new IllegalAccessException("Out of token");
      String token = tokenBucket.poll();
      tokenCount--;
      return token;
    }
  }

  public void fillTokenOne(){
    synchronized (this){
      if (tokenCount >= tokenLimit)
        return;
      tokenBucket.add(UUID.randomUUID().toString());
      tokenCount++;
      System.out.println("Filled token and current token count " + tokenCount);
    }
  }

  public void start(){
    if (inService )
      return;
    inService = true;

    //create token bucket and pre fill
    tokenBucket = new LinkedList<>();
    IntStream.range(0, tokenLimit).forEach( i -> fillTokenOne());

    System.out.println(">>>>>>>>>>>" + tokenCount);
    fillBucketTimer = new Timer();
    TimerTask task = new TimerTask() {
      @Override
      public void run() {
        fillTokenOne();;
      }
    };
    fillBucketTimer.schedule(task, 0L, fillTokenInterval );
  }

  public void stop(){
    if (!inService)
      return;
    fillBucketTimer.cancel();
    inService = false;
  }

  public static void main(String [] args){
    TokenProvider provider = new TokenProvider();
    provider.start();
    while(true){
      try{
        Thread.sleep(400L);
        System.out.println(">>>>> Get token" + provider.getToken());

      }catch(Exception e ){
        System.out.println("Error " + e.getMessage());
      }finally {

      }
    }
  }
}
