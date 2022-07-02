package com.example.misc;

public class CharShift {

  public static void main(String[] args) {

    String str = "abcde";
    for (int i = 0; i < str.length(); i++) {

      str= str.substring(1,str.length()) + str.charAt(0);
      System.out.println(str);

    }

  }

  /**
   * Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
   *
   * A shift on s consists of moving the leftmost character of s to the rightmost position.
   *
   * For example, if s = "abcde", then it will be "bcdea" after one shift.
   *
   *
   * Example 1:
   *
   * Input: s = "abcde", goal = "cdeab"
   * Output: true
   * Example 2:
   *
   * Input: s = "abcde", goal = "abced"
   * Output: false
   * @param s
   * @param goal
   * @return
   */
  public boolean rotateString(String s, String goal) {
    for (int i = 0; i < s.length() ; i++) {
      s = s.substring(1, s.length()) + s.charAt(0);
      if (s.equals(goal)) {
        return true;
      }
    }
    return false;
  }

}
