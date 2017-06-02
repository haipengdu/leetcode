package com.hdu;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by hdu on 5/3/17.
 */
public class TinyUrlProvider {

  String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
  //
  String baseUrl = "http://test.com/";
  int tinyUrlLength = 9;
  //think about insert, retrieve, and space
  Map<String, String> urls = new HashMap<String, String>();

  public static void main(String [] args){
    TinyUrlProvider tinyUrlProvider = new TinyUrlProvider();
    String url = "http://interview.com/" + tinyUrlProvider.getRandomString(1000);
    String tinyUrl = tinyUrlProvider.toTinyUrl(url);
    assert tinyUrl.length() == tinyUrlProvider.baseUrl.length() + tinyUrlProvider.tinyUrlLength;
    String reversedUrl = tinyUrlProvider.fromTinyUrl(tinyUrl);

    assert url.equals(reversedUrl);
    System.out.println(url);
    System.out.println(reversedUrl);
    System.out.println(tinyUrl);

    //add tests for large urls to make sure no duplicate
  }
  public String toTinyUrl(String url){
    String path = getRandomString(tinyUrlLength);
    urls.put(path, url);

    return baseUrl + path;
  }

  public String fromTinyUrl(String tinyUrl){
    if (!tinyUrl.startsWith(baseUrl))
      throw new IllegalArgumentException("This is not tiny url we support " + tinyUrl);
    String path = tinyUrl.substring(baseUrl.length());
    String url = urls.get(path);
    if ( url == null )
      throw new IllegalArgumentException("Cannot find the url from tiny url " + tinyUrl);
    return url;
  }

  private String getRandomString(int length){
    if (length <= 0 )
      throw new IllegalArgumentException("Length must be greater than 0");

    Random r = new Random(System.currentTimeMillis());
    StringBuilder sb = new StringBuilder();
    for(int i =0; i < length; i++){
      int index = Math.abs(r.nextInt(chars.length()));
      sb.append(chars.charAt(index));
    }
    return sb.toString();
  }
}
