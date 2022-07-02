package com.example;


import java.util.HashMap;
import java.util.Map;

/**
 * Input: nums = [2,7,11,15], target = 9
 * <pre>
 *
 * Time Complexity : O(n), as we are iterating through the array.
 *
 *  Space Complexity : O(n), as we are storing each and every number and its index in hashmap.
 * </pre>
 */

public class CountPairs {

  public static void main(String[] args) {

    int[] array = {2, 7, 11, 15};
    int[] result = twoSum(array, 9);

    System.out.println(result[0] + "   " + result[1]);


  }

//  Time complexity: O(n). We traverse the list containing nn elements only once.
//  Each lookup in the table costs only O(1)O(1) time.
//
//  Space complexity: O(n). The extra space required depends on the number of items stored in the
//  hash table, which stores at most n elements.
  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[] { map.get(complement), i };
      }
      map.put(nums[i], i);
    }
    // In case there is no solution, we'll just return null
    return null;
  }

  public static int[] twoSum1(int[] nums, int target) {
    Map<Integer, Integer> hash = new HashMap<>();
    int[] arr = new int[2];

    for (int i = 0; i < nums.length; i++) {
      int temp = target - nums[i];
      if (hash.containsKey(temp)) {
        arr[0] = hash.get(temp);
        arr[1] = i;
        return arr;
      }
      hash.put(nums[i], i);
    }
    return arr;
  }
}
