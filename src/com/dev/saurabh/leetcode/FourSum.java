package com.dev.saurabh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Copyright (c)
 * User: saurabh
 * Date: 8/7/12
 * Time: 7:09 AM
 * This file is created and owned by Saurabh Kr Singh (saurabh.nsit@gmail.com).
 * The code written here is being released under Apache 2.0 License
 */
public class FourSum {

    public static void main(String [] args)
    {
        FourSum fourSum = new FourSum();
        ArrayList<ArrayList<Integer>> result = fourSum.getFourSum(new int[]{-1,0,1,2,-1,-4}, -1);
        for(ArrayList<Integer> quadrlet : result)
        {
            System.out.println(""+quadrlet.get(0)+" ,"+quadrlet.get(1)+" ,"+quadrlet.get(2)+" ,"+quadrlet.get(3));
        }
    }

    public ArrayList<ArrayList<Integer>> getFourSum(int[] num, int target)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        int i, j, end, start;
        int first, second;
        int currentSum;

        for (i = 0; i < num.length - 3; ++ i)
        {
            if(i>0)
            {
                if(num[i] == num[i-1])
                {
                    continue;
                }
            }
            first = num[i];

            for (j = i + 1; j < num.length - 2; ++j)
            {
                if(j>(i+1))
                {
                    if(num[j] == num[j-1])
                    {
                        continue;
                    }
                }
                second = num[j];

                start = j+ 1;
                end = num.length - 1;
                while (start < end)
                {
                    currentSum = first + second + num[start] + num[end];
                    if (currentSum < target)
                        while (++start != end && num[start - 1] == num[start]);
                    else if (currentSum == target)
                    {
                        ArrayList<Integer> quadrlet = new ArrayList<Integer>();
                        quadrlet.add(first);
                        quadrlet.add(second);
                        quadrlet.add(num[start]);
                        quadrlet.add(num[end]);
                        result.add(quadrlet);
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
                    else if(currentSum > target)
                    {
                        end--;
                    }
                }
            }
        }


        return result;

    }
}
