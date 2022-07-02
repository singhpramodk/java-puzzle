package com.example.number;

public class MaxWaterContainer {


  /**
   * Approach 1: Brute Force
   * <p>
   * In this case, we will simply consider the area for every possible pair of the lines and find
   * out the maximum area out of those.
   * <p>
   * Note: Brute force approaches are often included because they are intuitive starting points when
   * solving a problem. However, they are often expected to receive Time Limit Exceeded since they
   * would not be accepted in an interview setting.
   * <p>
   * Time Complexity:  O(n^2)
   * <p>
   * Space Complexity:  O(1) *
   *
   * @param height
   * @return
   */
  public static int maxArea(int[] height) {
    int maxarea = 0;
    for (int left = 0; left < height.length; left++) {
      for (int right = left + 1; right < height.length; right++) {
        int width = right - left;
        maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * width);
      }
    }
    return maxarea;
  }

  /**
   * Initially we consider the area constituting the exterior most lines. Now, to maximize the area,
   * we need to consider the area between the lines of larger lengths. If we try to move the pointer
   * at the longer line inwards, we won't gain any increase in area, since it is limited by the
   * shorter line. But moving the shorter line's pointer could turn out to be beneficial, as per the
   * same argument, despite the reduction in the width. This is done since a relatively longer line
   * obtained by moving the shorter line's pointer might overcome the reduction in area caused by
   * the width reduction.
   * <p>
   * Time Complexity:  O(n)
   * <p>
   * Space Complexity:  O(1)
   *
   * @param height
   * @return
   */
  public static int maxAreaBetter(int[] height) {
    int maxarea = 0;
    int left = 0;
    int right = height.length - 1;
    while (left < right) {

      int width = right - left;
      int area = Math.min(height[left], height[right]) * width;

      maxarea = Math.max(maxarea, area);
      if (height[left] <= height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return maxarea;
  }

  public static void main(String[] args) {
    int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};

    System.out.println(maxAreaBetter(heights));
  }

}
