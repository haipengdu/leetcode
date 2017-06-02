package com.hdu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by hdu on 4/24/17.
 */
public class FileCheckSum {

  public static void main(String[] args) throws Exception {

    CodeUtil.printObject(new FileCheckSum().getChecksum("/tmp/test2.mpg"));
  }

  public String getChecksum(String fileName) throws NoSuchAlgorithmException {

    byte[] buffer = new byte[1024];
    MessageDigest digest = MessageDigest.getInstance("MD5");
    try (DigestInputStream input = new DigestInputStream(new FileInputStream(fileName), digest)) {
      int length;
      while ( (length =input.read(buffer)) > 0);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return  String.format("%032X", new BigInteger(1, digest.digest()));
  }
}
