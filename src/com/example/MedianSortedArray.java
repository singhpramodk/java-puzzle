package com.example;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianSortedArray {

  public static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {

    PriorityQueue<Integer> biggerHeap = highers.size() > lowers.size() ? highers : lowers;
    PriorityQueue<Integer> smallerHeap = highers.size() > lowers.size() ? lowers : highers;

    if (biggerHeap.size() == smallerHeap.size()) {
      return ((double) biggerHeap.peek() + smallerHeap.peek()) / 2;
    } else {
      return biggerHeap.peek();
    }


  }

  public static void addNumber(int[] nums, PriorityQueue<Integer> lowers,
      PriorityQueue<Integer> highers) {

    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (lowers.size() == 0 || num < lowers.peek()) {
        lowers.add(num);
      } else {
        highers.add(num);
      }
      rebalance(lowers, highers);
    }
  }

  public static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {

    PriorityQueue<Integer> biggerHeap = highers.size() > lowers.size() ? highers : lowers;
    PriorityQueue<Integer> smallerHeap = highers.size() > lowers.size() ? lowers : highers;

    if (biggerHeap.size() - smallerHeap.size() >= 2) {
      smallerHeap.add(biggerHeap.poll());
    }
  }

  public static void main(String[] args) {
    int[] nums1 = {1, 2, 7}, nums2 = {3, 4, 5};

    //Store lower numbers  with highest value at root node
    PriorityQueue<Integer> lowers = new PriorityQueue<>(Collections.reverseOrder());

    //By default ascending order- Store higher numbers with lowest value at root node
    PriorityQueue<Integer> highers = new PriorityQueue<>();

    addNumber(nums1, lowers, highers);
    addNumber(nums2, lowers, highers);

    double median = getMedian(highers, lowers);

    System.out.println(median);
  }

}
