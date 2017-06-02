package com.hdu;

import java.util.Arrays;

public class LongestPalindrome {

  public static void main(String[] args) {
    CodeUtil.printObject(new LongestPalindrome().longestPalindrome("aaaAaaaa"));
  }


  public String longestSubPalindromeWith(String s) {
    if (s == null || s.length() <= 1)
      return s;
    int l = 1;
    int begin = 0;
    int i = 0;
    int n = s.length();
    while (i < n - l / 2) {
      int left = i, right = i;
      while ( right < n - 1 && s.charAt(right) == s.charAt(right+1))
        right++;
      while ( left > 0 && right< n -1 &&  s.charAt(left-1) == s.charAt(right+1))
        left--;
      if ( l < right -left + 1){
        l = right -left + 1;
        begin = left;
      }
    }
    return s.substring(begin, begin+l);
  }

  public int longestPalindrome(String s){
    if ( s == null || s.length() == 0 )
      return 0;
    int [] smallChars = new int[26];
    int [] upperChars = new int[26];
    for(int i = 0 ; i < s.length(); i++){
      if ( s.charAt(i) > 'Z')
        smallChars[s.charAt(i) - 'a']++;
      else
        upperChars[s.charAt(i) - 'A']++;
    }
    int length = 0;

    for(int i =0; i < 26; i++){
      int l1 = smallChars[i] / 2;
      int l2 = upperChars[i] / 2;
      smallChars[i] = smallChars[i] - l1*2;
      upperChars[i] = upperChars[i] - l2*2;

      length += l1 * 2 + l2*2;
    }
    for(int i = 0; i < 26; i++) {
      if (smallChars[i] > 0 || upperChars[i] > 0) {
        length++;
        break;
      }
    }
    return length;
  }
}
/*def longestPalindrome(self, s):
        n = len(s)
        if n <=1:
            return(s)

        l = 1
        begin = 0

        i = 0
        while i < n - l//2:
            left = right = i
            while right < (n-1) and s[right] == s[right + 1]:
                right = right + 1
            i = right + 1
            while left > 0 and right < (n-1) and s[left - 1] == s[right + 1]:
                left =left - 1
                right = right + 1
            if l < (right - left + 1):
                l = right - left + 1
                begin = left
        return(s[begin:(begin + l)])
 */