package com.example;


/**
 * Approach 1: Two Pointers Algorithm
 * <p>
 * Since the array is already sorted, we can keep two pointers i and j, where i is the
 * slow-runner while j is the fast-runner. As long as nums[i] = nums[j], we increment j to skip the
 * duplicate.
 * <p>
 * When we encounter nums[j]!= nums[i] , the duplicate run has ended so we must copy its value to
 * nums[i + 1]. i is then incremented and we repeat the same process again until j reaches the end
 * of array.
 * <p>
 * Time complextiy : O(n). Assume that nn is the length of array. Each of ii and jj traverses at
 * most n steps.
 * <p>
 * Space complexity : O(1).
 */
public class RemoveDuplicate {

  public static void main(String[] args) {
    int[] array = {2, 2, 7, 11, 15};
    int newLen = removeDuplicates(array);

    System.out.println("==========" + newLen);

    for (int j = 0; j < newLen; j++) {
      System.out.print(array[j] + "   ");

    }
  }

  public static int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[j] != nums[i]) {
        i++;
        nums[i] = nums[j];
      }
    }
    return i + 1;
  }
}
