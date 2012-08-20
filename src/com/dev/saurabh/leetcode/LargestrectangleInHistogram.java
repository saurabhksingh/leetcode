package com.dev.saurabh.leetcode;

/**
 * Copyright (c)
 * User: saurabh
 * Date: 8/13/12
 * Time: 1:41 AM
 * This file is created and owned by Saurabh Kr Singh (saurabh.nsit@gmail.com).
 * The code written here is being released under Apache 2.0 License
 */
public class LargestrectangleInHistogram {

    public static void main(String [] args)
    {
        LargestrectangleInHistogram instance =  new LargestrectangleInHistogram();
        //System.out.println(instance.largestRectangleArea(new int[]{4,7,6,8,5,9,1,26}));
        System.out.println(instance.largestRectangleArea2(new int[]{4, 7, 6, 8, 5, 9, 1, 26}));
    }

    private int largestRectangleArea2(int[] height)
    {
        int result = 0;
        int count = 1;
        for(int i=1; i<height.length; i++)
        {
            if(height[i] >= height[i-1])
            {
                continue;
            }
            else
            {
                count = 1;
                for(int j=i-1; j>=0; j--)
                {
                  result = Math.max(result, height[j]*count);
                  if(height[j]> height[i])
                  {
                      height[j] = height[i];
                  }
                  count++;
                }
            }
        }
        count = 1;
        for(int i=height.length-1; i>=0; i--)
        {
           result = Math.max(result, height[i]*count);
           count++;
        }

        return result;
    }

    public int largestRectangleArea (int [] height)
    {
        int result = 0;

        int [] rectangleRecord = new int[height.length];
        if(height.length == 1)
        {
            return height[0];
        }

        for(int i=0;i<height.length-1; i++)
        {
            int startNum = height[i];
            int startIndex = i;
            int max = startNum;
            for(int j=i+1; j<height.length; j++)
            {
                if(height[j] == 0)
                {
                    if(max > result)
                    {
                        result = max;
                    }
                    break;
                }
                if(startNum == 0)
                {
                    startNum = height[j];
                    max = startNum;
                    startIndex = j;
                    if(max > result)
                    {
                        result = max;
                    }
                }
                else if(height[j] >= startNum)
                {
                    max = max+startNum;
                    if(max > result)
                    {
                        result = max;
                    }

                    if(height[j] > result)
                    {
                        max = height[j];
                        result = max;
                        startNum = height[j];
                        startIndex = j;
                    }
                }
                else
                {
                    max = height[j]*(j+1-startIndex);
                    startNum = height[j];
                    if(max > result)
                    {
                        result = max;
                    }
                }
            }
        }

        return  result;
    }
}
