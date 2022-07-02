package com.example.misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MajorityElement {


  /**
   * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
   *
   *
   *
   * Example 1:
   *
   * Input: nums = [3,2,3]
   * Output: [3]
   * Example 2:
   *
   * Input: nums = [1]
   * Output: [1]
   * Example 3:
   *
   * Input: nums = [1,2]
   * Output: [1,2]
   * @param nums
   * @return
   */
  public List<Integer> majorityElement(int[] nums) {
    Set<Integer> set = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {
      int count = 0;
      for (int j = i; j < nums.length; j++) {
        if (nums[i] == nums[j]) {
          count++;
        }
      }

      // if count is greater than n/3 means
      // current element is majority element
      if (count > nums.length / 3) {

        set.add(nums[i]);
      }
    }
    return new ArrayList<>(set);
  }

}
