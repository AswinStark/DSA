package com.aswinstark.patterns.two_pointers;

import java.util.Arrays;
import java.util.List;

/*
    @author - Aswin
 */
public class NthNodeFromLast_003 {
    /*
        Given the head of a singly linked list, remove the nth
        node from the end of the list and return its head.
     */

    private static ListNode removeNthLastNode(ListNode head, int n) {

        ListNode lHead = head;
        ListNode rHead = head;
        for(int i=0; i<n; i++){
            rHead = rHead.next;
        }

        if(rHead==null){
            head = head.next;
            return head;
        }
        while(rHead.next!=null){
            rHead=rHead.next;
            lHead = lHead.next;
        }
        lHead.next = lHead.next.next;
        return head;
    }

    static class LinkedList {
        ListNode head;

        // Default constructor
        public LinkedList() {
            head = null;
        }

        // Constructor to initialize from a list of values
        public LinkedList(List<Integer> values) {
            head = null;
            createLinkedList(values);
        }

        // Function to create a linked list from a list of values
        private void createLinkedList(List<Integer> values) {
            if (values.isEmpty()) {
                head = null;
                return;
            }

            head = new ListNode(values.get(0));
            ListNode current = head;
            for (int i = 1; i < values.size(); i++) {
                current.next = new ListNode(values.get(i));
                current = current.next;
            }
        }

    }

    class PrintList {
        // Function to display the linked list
        public static void display(ListNode head) {
            ListNode current = head;
            while (current != null) {
                System.out.print(current.val + " -> ");
                current = current.next;
            }
            System.out.println("None");
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        // Constructor
        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> inputs = Arrays.asList(
                Arrays.asList(23, 89, 10, 5, 67, 39, 70, 28),
                Arrays.asList(34, 53, 6, 95, 38, 28, 17, 63, 16, 76),
                Arrays.asList(288, 224, 275, 390, 4, 383, 330, 60, 193),
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9),
                Arrays.asList(69, 8, 49, 106, 116, 112, 104, 129, 39, 14, 27, 12)
        );

        int[] n = {4, 1, 6, 9, 11};

        for (int i = 0; i < inputs.size(); i++) {
            LinkedList inputLinkedList = new LinkedList(inputs.get(i));
            System.out.print((i + 1) + ".\tLinked List:\t\t");
            PrintList.display(inputLinkedList.head);
            System.out.print("\n\tn = " + n[i]);
            System.out.print("\n\tUpdated Linked List:\t");
            PrintList.display(removeNthLastNode(inputLinkedList.head, n[i]));
            System.out.println();
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }


}
