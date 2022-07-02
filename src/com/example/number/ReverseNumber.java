package com.example.number;

public class ReverseNumber {

//  Time Complexity: O(log10(x)).

//  Space Complexity: O(1)O(1).


  public static int reverse(int x) {
    int reversed = 0;
    while (x != 0) {
      int remainder = x % 10;
      reversed = reversed * 10 + remainder;
      x = x / 10;
    }
    return reversed;
  }

  public static void main(String[] args) {



//    System.out.println(reverse(123));
//
//    System.out.println(reverse(-123));

    //int max -2,147,483,648 to 2,147,483,647

    if (Integer.MAX_VALUE > 1534236469) {
      System.out.println("true");
    }

    System.out.println(reverse(1534236469));

  }

}
