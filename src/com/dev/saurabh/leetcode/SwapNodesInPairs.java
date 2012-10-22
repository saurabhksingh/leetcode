package com.dev.saurabh.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: saurabh
 * Date: 10/22/12
 * Time: 12:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class SwapNodesInPairs {

    public static void main(String [] args)
    {
        SwapNodesInPairs instance = new SwapNodesInPairs();
        instance.runTest();
    }

    private void runTest() {

        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        ListNode currentNode = node;
        head.next = node;
        node = new ListNode(3);
        currentNode.next = node;
        currentNode = node;
//        node = new ListNode(4);
//        currentNode.next = node;
        currentNode = node;
//        node = new ListNode(5);
//        currentNode.next = node;
//        currentNode = node;

        ListNode newRoot = swapPairs(head);
        while(newRoot != null)
        {
            System.out.println(newRoot.val);
            newRoot = newRoot.next;
        }

    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode swapPairs(ListNode head) {

        ListNode result = head;

        if(head == null)
        {
            return null;
        }
        if(head.next == null)
        {
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;
        if(second != null)
        {
            result = second;
        }
        ListNode lastEnd = first;
        while(first != null && second != null)
        {
            ListNode temp = second.next;
            second.next = first;
            first.next = temp;
            if(lastEnd != null)
            {
                lastEnd.next = second;
            }
            lastEnd = first;
            first = temp;
            if(first != null)
            {
                second = first.next;
            }

        }
        if(first != null)
        {
            lastEnd.next = first;
        }
        else
        {
            lastEnd.next = null;
        }

        return result;

    }
}
