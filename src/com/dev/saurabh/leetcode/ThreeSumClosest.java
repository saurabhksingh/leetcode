package com.dev.saurabh.leetcode;

import java.util.Arrays;

/**
 * Copyright (c)
 * User: saurabh
 * Date: 8/7/12
 * Time: 2:12 AM
 * This file is created and owned by Saurabh Kr Singh (saurabh.nsit@gmail.com).
 * The code written here is being released under Apache 2.0 License
 */
public class ThreeSumClosest {

    public static void main(String [] args)
    {
        ThreeSumClosest threeSum = new ThreeSumClosest();
        int result = threeSum.threeSumClosest(new int[]{0,2,1,-3}, 1);
        System.out.println(result);
    }

    public int threeSumClosest(int[] num, int target)
    {
        int result = Integer.MAX_VALUE;
        int smallest = Integer.MAX_VALUE;
        Arrays.sort(num);
        int start = 0;
        for(int i=0; i<=num.length-3; i++)
        {
            int first = num[i];
            start = i+1;
            int end = num.length-1;

            while(start < end)
            {
                int second = num[start];
                int third  = num[end];
                int sum = (first+second+third);
                int diff = Math.abs(sum-target);
                if(diff < smallest)
                {
                    smallest = diff;
                    result = sum;
                }
                if(sum < target)
                    start++;
                else
                    end--;


            }
        }

        return result;

    }
}
