package com.example.linklist;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class RemoveNthFromEnd {

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    //Maintain two pointer. First one n place forward
    ListNode currentNode = head;
    for (int i = 0; i < n; i++) {
      currentNode = currentNode.next;
    }

    //if we have reached at the end the first node is nth row from the end. Return head without first node
    if (currentNode == null) {
      return head.next;
    }

    //Start second pointer from head
    ListNode nodeBeforeRemoved = head;

    //Move till end
    while (currentNode.next != null) {
      currentNode = currentNode.next;
      nodeBeforeRemoved = nodeBeforeRemoved.next;
    }
    nodeBeforeRemoved.next = nodeBeforeRemoved.next.next;
    return head;
  }

  public static ListNode removeNthFromStart(ListNode head, int n) {

    ListNode curr = head;
    ListNode prev = null;
    //Delete first node
    if (n == 0) {
      return head.next;
    }

    for (int i = 0; i < n - 1; i++) {
      prev = curr;
      curr = curr.next;
    }
    prev.next = curr.next;
    return head;
  }


  /**
   * Write a function to delete a node in a singly-linked list. You will not be given access to the
   * head of the list, instead you will be given access to the node to be deleted directly.
   * <p>
   * It is guaranteed that the node to be deleted is not a tail node in the list.
   *
   * Solution - Set the value of to be deleted node eual to next node value
   *
   *
   * @param node
   */
  public static void deleteByNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
  }

  public static ListNode addFirst(ListNode head, int val) {
    ListNode first = new ListNode(val);
    first.next = head;
    return first;
  }

  public static void main(String[] args) {
    ListNode head = null;
    head = addFirst(head, 10);
    head = addFirst(head, 20);
    head = addFirst(head, 30);
    head = addFirst(head, 40);
    head = addFirst(head, 50);
    System.out.println(head.next.val);

    //Delete second last node
    removeNthFromEnd(head, 2);

    print(head);

    //Delete node with value 20
    deleteByNode(head.next);
    print(head);

    head = removeNthFromStart(head, 0);
    print(head);

  }

  private static void print(ListNode head) {
    System.out.println("================");
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }
}