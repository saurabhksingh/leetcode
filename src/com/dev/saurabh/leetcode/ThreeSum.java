package com.dev.saurabh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Copyright (c)
 * User: saurabh
 * Date: 8/7/12
 * Time: 1:18 AM
 * This file is created and owned by Saurabh Kr Singh (saurabh.nsit@gmail.com).
 * The code written here is being released under Apache 2.0 License
 */
public class ThreeSum {

    public static void main(String [] args)
    {
       ThreeSum threeSum = new ThreeSum();
        ArrayList<ArrayList<Integer>> result = threeSum.threeSum(new int[]{1,-1,-1,0});
        for(ArrayList<Integer> triplets : result)
        {
            System.out.println(""+triplets.get(0)+" ,"+triplets.get(1)+" ,"+triplets.get(2));
        }
    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] num)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        Arrays.sort(num);
        int start = 0;
        for(int i=0; i<=num.length-3; i++)
        {
            int first = num[i];
            start = i+1;
            int end = num.length-1;
            if(i>0)
            {
                if(num[i] == num[i-1])
                {
                    continue;
                }
            }
            while(start < end)
            {
                int second = num[start];
                int third  = num[end];
                int sum = (first+second+third);
                if(sum == 0)
                {
                    ArrayList<Integer> triplet = new ArrayList<Integer>();
                    triplet.add(first); triplet.add(second); triplet.add(third);
                    result.add(triplet);
                    while(start < num.length-1)
                    {
                        start++;
                        if(num[start] != num[start-1])
                            break;
                    }
                    while(end > 0)
                    {
                        end--;
                        if(num[end] != num[end+1])
                            break;
                    }
                }
                else if(sum > 0)
                {
                    end--;
                }
                else
                {
                    start++;
                }
            }
        }

        return result;

    }
}
