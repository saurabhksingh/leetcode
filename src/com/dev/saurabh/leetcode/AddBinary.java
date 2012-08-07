package com.dev.saurabh.leetcode;

/**
 * Copyright (c)
 * User: saurabh
 * Date: 8/7/12
 * Time: 3:01 AM
 * This file is created and owned by Saurabh Kr Singh (saurabh.nsit@gmail.com).
 * The code written here is being released under Apache 2.0 License
 */
public class AddBinary {

    public static void main(String [] args)
    {
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.add("11", "1001"));
    }

    private String add(String a, String b) {

        String result = "";

        if(a.length() > b.length())
        {
            String temp = a;
            a = b;
            b = temp;
        }

        int carry = 0;
        int i=0;
        for(i=0; i<a.length(); i++)
        {
            int sum = (a.charAt(a.length()-1-i)-'0') + (b.charAt(b.length()-1-i)-'0')+carry;
            carry = sum/2;
            sum = sum%2;
            result = sum+result;
        }
        if(carry > 0)
        {
            for(i=b.length()-a.length()-1; i>=0; i--)
            {
                if(carry == 0)
                    break;
                int sum = (b.charAt(i)-'0')+carry;
                carry = sum/2;
                sum = sum%2;
                result = sum+result;
            }
            if(carry > 0)
            {
                result = carry+result;
            }
            else if(i>=0)
            {
              result = b.substring(0,i+1)+result;
            }
        }
        else
        {
                result = b.substring(0,b.length()-a.length())+result;
        }

        return result;
    }
}
