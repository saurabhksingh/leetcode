package com.dev.saurabh.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: saurabh
 * Date: 10/7/12
 * Time: 3:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class MaximumSubarray {

    public static void main(String [] args)
    {
        int [] in = new int[]{-2,-1};
        MaximumSubarray instance = new MaximumSubarray();
        System.out.println(instance.maxSubArray(in));
    }

    public int maxSubArray(int [] A)
    {
        int currentSum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MIN_VALUE;
        boolean anyPositive = false;

        for(int i=0; i<A.length; i++)
        {
            if(A[i] >= 0)
            {
                min = 0;
                anyPositive = true;
                break;
            }

            if(min < A[i])
            {
                min = A[i];
            }
        }
        if(!anyPositive)
        {
            return min;
        }
        for(int i=0; i<A.length; i++)
        {
            int sum = A[i] + currentSum;
            if(sum<min)
            {
                currentSum = 0;
                continue;
            }
            currentSum = sum;
            if(currentSum > max)
            {
                max = currentSum;
            }
        }

        return max;
    }
}
