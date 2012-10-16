package com.dev.saurabh.leetcode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: saurabh
 * Date: 10/7/12
 * Time: 7:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class MergeTwoSortedLists {

    private void runTest()
    {
        ArrayList<ListNode> input = new ArrayList<ListNode>();
        ListNode l1 = null, l2 = null;

        ListNode list = new ListNode(-9);l1 = list;list.next=new ListNode(3);//list = list.next;list.next=new ListNode(10);

        list = new ListNode(5);l2 = list;list.next=new ListNode(7);//list = list.next;list.next=new ListNode(12);


        ListNode out = mergeTwoLists(l1, l2);

        while(out != null)
        {
            System.out.println(out.val);
            out = out.next;
        }
    }

    public static void main(String [] args)
    {
        MergeTwoSortedLists instance = new MergeTwoSortedLists();
        instance.runTest();
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        int firstLen = 0;
        ListNode temp = l1;
        while(temp != null)
        {
            firstLen++;
            temp = temp.next;
        }

        int secondLen = 0;
        temp = l2;
        while(temp != null)
        {
            secondLen++;
            temp = temp.next;
        }

        if(secondLen > firstLen)
        {
            temp = l1;
            l1 = l2;
            l2 = temp;
        }

        ListNode result = l1;
        ListNode prev = l1;
        boolean l1Changed = false;

        while(l1 != null && l2 != null)
        {
            if(l1.val <= l2.val)
            {
                prev = l1;
                if((l1.next != null && l2.val<l1.next.val))
                {
                    temp = l2;
                    l2 = l2.next;
                    temp.next = l1.next;
                    l1.next = temp;
                }
                l1 = l1.next;
                l1Changed = true;
            }
            else if(l2.val < l1.val)
            {
                temp = l2;
                l2 = l2.next;
                temp.next = l1;
                l1 = temp;
                if(!l1Changed) result = l1;
            }

        }

        if(l2 != null)
        {
             while(l2 != null)
             {
                 prev.next = l2;
                 prev = l2;
                 l2 = l2.next;
             }
        }

        return result;
    }
}
