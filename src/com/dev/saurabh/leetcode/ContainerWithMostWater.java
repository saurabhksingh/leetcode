package com.dev.saurabh.leetcode;

/**
 * Copyright (c)
 * User: saurabh
 * Date: 8/11/12
 * Time: 3:10 AM
 * This file is created and owned by Saurabh Kr Singh (saurabh.nsit@gmail.com).
 * The code written here is being released under Apache 2.0 License
 */
public class ContainerWithMostWater {

    public static void main(String [] args)
    {
        ContainerWithMostWater instance =  new ContainerWithMostWater();

    }

    public int maxArea (int [] height)
    {
        int result = 0;

        //since we are not sure about the ordering of heights, lets assume that
        //maximizing of area will majorly depend on base that is i-j. Also since
        //slanting is not allowed the valid height will be minimum height of two
        //towers in question

        if(height == null || height.length == 0)
        {
            return 0;
        }

        int minHeightOfFarthestTowers = height[0]<height[height.length-1]?height[0]:height[height.length-1];

        result = (height.length-1) * minHeightOfFarthestTowers;

        int start = 0;
        int end = height.length-1;

        if(height[0] < height[height.length-1]) start++;
        else end--;

        while(start < end)
        {
          int currentArea = (end-start) * (height[start]<height[end]?height[start]:height[end]);
          if(height[start]<height[end]) start++;
          else end--;

          if(currentArea > result)
              result = currentArea;
        }

        return  result;
    }
}
