package com.example;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxPriorityQueue {

  public static void main(String[] args) {
    // There is overflow problem when using simple lambda as comparator, as pointed out by Фима Гирин.
    PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);

    //PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));

    pq.add(10);
    pq.add(5);
    System.out.println(pq.peek());


    //Min Queue - By default ascending order
    PriorityQueue<Integer> minQueue = new PriorityQueue<>();

    minQueue.add(10);
    minQueue.add(5);
    System.out.println("Max Queue: " + minQueue.peek());

    //Max Queue
    PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

    maxQueue.add(10);
    maxQueue.add(5);
    System.out.println("Max Queue: " + maxQueue.peek());
  }

}
