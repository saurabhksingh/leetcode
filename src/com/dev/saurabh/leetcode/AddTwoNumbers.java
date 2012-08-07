package com.dev.saurabh.leetcode;

/**
 * Copyright (c)
 * User: saurabh
 * Date: 8/7/12
 * Time: 10:57 PM
 * This file is created and owned by Saurabh Kr Singh (saurabh.nsit@gmail.com).
 * The code written here is being released under Apache 2.0 License
 */

class ListNode
{
    int val;
    ListNode next;
    ListNode(int data)
    {
        val = data;
        next = null;
    }
}
public class AddTwoNumbers
{
    public static void main(String [] args)
    {
        AddTwoNumbers instance = new AddTwoNumbers();
        ListNode first = new ListNode(2);
        first.next = new ListNode(4);
        first.next.next = new ListNode(3);

        ListNode second = new ListNode(5);
        second.next = new ListNode(6);
        second.next.next = new ListNode(4);

        ListNode result = instance.addTwoNumbers(first, second);

        while(result != null)
        {
            System.out.print(result.val);
            result = result.next;
        }
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
        {
            return l2;
        }
        else if(l2 == null)
        {
            return l1;
        }

        ListNode first = l1;
        ListNode second = l2;
        ListNode result = null;
        ListNode rear = null;
        int carry = 0;
        while(first != null && second!= null)
        {
            int sum = first.val + second.val + carry;
            carry = sum/10;
            sum = sum%10;

            if(result == null)
            {
               result = new ListNode(sum);
               rear =  result;
            }
            else
            {
               ListNode node = new ListNode(sum);
               rear.next = node;
               rear = node;
            }

            first = first.next;
            second = second.next;
        }
        ListNode restOfList = null;
        if(first == null && second != null)
        {
            restOfList = second;
        }
        else if(first != null && second == null)
        {
            restOfList = first;
        }
        if(restOfList !=null)
        {
            while(restOfList != null)
            {
                int sum = restOfList.val + carry;
                carry = sum/10;
                sum = sum%10;

                ListNode node = new ListNode(sum);
                rear.next = node;
                rear = node;
                restOfList = restOfList.next;
            }
        }

        if(carry > 0)
        {
            ListNode node = new ListNode(carry);
            rear.next = node;
        }

        return result;
    }
}
