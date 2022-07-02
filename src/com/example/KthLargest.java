package com.example;

import java.util.PriorityQueue;


/**
 * The idea is to init a heap "the smallest element first", and add all elements from the array into
 * this heap one by one keeping the size of the heap always less or equal to k. That would results
 * in a heap containing k largest elements of the array.
 * <p>
 * The head of this heap is the answer, i.e. the kth largest element of the array.
 * <p>
 * The time complexity of adding an element in a heap of size k is O(logk), and we do it N times
 * that means O(Nlogk) time complexity for the algorithm.
 * <p>
 * Space Complexity: This algorithm improves time complexity, but one pays with O(k) space
 * complexity.
 */
public class KthLargest {

  public static int findKthLargest(int[] nums, int k) {
    // init heap 'the smallest element first'. This is min heap
    //PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);


    // This initailize min heap
    PriorityQueue<Integer> heap = new PriorityQueue<Integer>();


    // keep k largest elements in the heap
    for (int n : nums) {
      heap.add(n);
      if (heap.size() > k) {
        heap.poll();
      }
    }

    // output
    return heap.poll();
  }

  public static void main(String[] args) {

    int[] array1 = {3, 2, 3, 1, 2, 4, 5, 5, 6};

    System.out.println(findKthLargest(array1, 4));

    int[] array2 = {3, 2, 1, 5, 6, 4};

    System.out.println(findKthLargest(array2, 4));
  }
}
