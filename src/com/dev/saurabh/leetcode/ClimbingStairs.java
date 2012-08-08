package com.dev.saurabh.leetcode;

/**
 * Copyright (c)
 * User: saurabh
 * Date: 8/8/12
 * Time: 7:46 PM
 * This file is created and owned by Saurabh Kr Singh (saurabh.nsit@gmail.com).
 * The code written here is being released under Apache 2.0 License
 */
public class ClimbingStairs {

    public static void main(String [] args)
    {

    }

    public int climbStairs(int n)
    {
        if(n < 3) return n;

        int n1 = 1; //1 way to climb stair of length 1
        int n2 = 2; //2 ways (1,1 and 2) to climb stairs
        int sum = 0;
        for(int i=n-3; i>=0; i--)
        {
            sum = n1+n2;
            n1 = n2;
            n2 = sum;
        }

        return sum;
    }
}
