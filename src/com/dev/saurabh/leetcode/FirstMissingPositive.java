package com.dev.saurabh.leetcode;

/**
 * Copyright (c)
 * User: saurabh
 * Date: 8/11/12
 * Time: 12:54 PM
 * This file is created and owned by Saurabh Kr Singh (saurabh.nsit@gmail.com).
 * The code written here is being released under Apache 2.0 License
 */
public class FirstMissingPositive {

    public static void main(String [] args)
    {
        FirstMissingPositive instance = new FirstMissingPositive();
        System.out.println(instance.firstMissingPositive(new int[]{1,2,0}));
    }

    public int firstMissingPositive(int[] A)
    {
        if(A == null || A.length==0)
        {
            return 1;
        }

        //partition array to put all +ves at one side
        int i = 0;
        int j = A.length - 1;
        while (i <= j)
        {
            if (A[i] <= 0 || A[i] > A.length)
            {
                ++i;
            }
            else
            {
                while (i <= j)
                {
                    if (A[j] > 0 && A[j] <= A.length)
                    {
                        --j;
                    }
                    else
                    {
                        int temp = A[i];
                        A[i] = A[j];
                        A[j] = temp;
                        ++i;

                        --j;
                        break;
                    }
                }
            }
        }

        int startIndex = i;

        for (; i < A.length; i++)
        {
            if(Math.abs(A[i]) - 1 < (A.length-startIndex) && A[Math.abs(A[i]) - 1+startIndex] > 0)
                A[Math.abs(A[i]) - 1+startIndex] = -A[Math.abs(A[i])+startIndex - 1];
        }

        for(i = startIndex; i < A.length; i++)
            if (A[i] > 0)
                return i+1-startIndex;

        return A.length-startIndex+1;
    }
}
