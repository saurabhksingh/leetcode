package com.dev.saurabh.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: saurabh
 * Date: 10/22/12
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class RotateList {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
     }

     public static void main(String [] args)
    {
        RotateList instance = new RotateList();
        instance.runTest();
    }

    private void runTest() {

        ListNode root = new ListNode(1);
        ListNode node = new ListNode(2);
        ListNode currentNode = node;
        root.next = node;
        node = new ListNode(3);
        currentNode.next = node;
        currentNode = node;
//        node = new ListNode(4);
//        currentNode.next = node;
//        currentNode = node;
//        node = new ListNode(5);
//        currentNode.next = node;
//        currentNode = node;

        ListNode newRoot = rotateRight(root,2);
        while(newRoot != null)
        {
            System.out.println(newRoot.val);
            newRoot = newRoot.next;
        }

    }

    public ListNode rotateRight(ListNode head, int n) {
        int length = 0;
        if(head == null)
        {
            return null;
        }
        if(n == 0)
        {
            return head;
        }
        ListNode currentNode = head;
        while(currentNode != null)
        {
            length++;
            currentNode = currentNode.next;
        }

        n = n%length;

        if(length == 1 || n == 0)
        {
            return head;
        }


        int count = 0;
        currentNode = head;
        while(count != n)
        {
           count++;
           currentNode = currentNode.next;
        }
        currentNode = currentNode.next;
        ListNode temp = head;
        ListNode tempLast = null;
        while(currentNode != null)
        {
            if(currentNode.next == null)
            {
                tempLast = currentNode;
            }
            temp = temp.next;
            currentNode = currentNode.next;
        }

        currentNode = temp.next;
        temp.next = null;
        if(tempLast == null)
        {
            tempLast = currentNode;
            while(tempLast.next != null)
            {
                tempLast = tempLast.next;
            }

        }

        tempLast.next = head;

        head = currentNode;

        return head;
    }
}
