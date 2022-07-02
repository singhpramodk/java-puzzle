package com.example;

public class NumberPalindrome {

  public static boolean IsPalindrome(int x) {
    // Special cases:
    // As discussed above, when x < 0, x is not a palindrome.
    // Also if the last digit of the number is 0, in order to be a palindrome,
    // the first digit of the number also needs to be 0.
    // Only 0 satisfy this property.
    if (x < 0 || (x % 10 == 0 && x != 0)) {
      return false;
    }

    int revertedNumber = 0;
    while (x > revertedNumber) {
      revertedNumber = revertedNumber * 10 + x % 10;
      x /= 10;
    }

    // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
    // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
    // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
    return x == revertedNumber || x == revertedNumber / 10;
  }


  public boolean isPalindrome(int num) {
    if (num < 0) {
      return false;
    }

    int reversed = 0;
    int original = num;
    while (num != 0) {
      int remainder = num % 10; // reversed integer is stored in variable
      //multiply reversed by 10 then add the remainder so it gets stored at next decimal place.
      reversed = reversed * 10 + remainder;
      num /= 10;  //the last digit is removed from num after division by 10.
    }
    // palindrome if original and reversed are equal
    return original == reversed;
  }

  public static void main(String[] args) {
    System.out.println(IsPalindrome(1234321));

    System.out.println(IsPalindrome(10));
  }


}
