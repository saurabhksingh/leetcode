package com.dev.saurabh.leetcode;

/**
 * Copyright (c)
 * User: saurabh
 * Date: 8/13/12
 * Time: 1:07 AM
 * This file is created and owned by Saurabh Kr Singh (saurabh.nsit@gmail.com).
 * The code written here is being released under Apache 2.0 License
 */
public class JumpGameII {

    public static void main(String [] args)
    {
        JumpGameII instance = new JumpGameII();
        System.out.println(instance.jump(new int[]{2,3,1,1,4}));
    }

    public int jump(int[] A)
    {
        int result = Integer.MAX_VALUE;

        if(A.length == 1)
        {
            result = 0;
        }
        else
        {
            int [] temp = new int [A.length];
            if(A[0] == 0)
            {
                return Integer.MAX_VALUE;
            }
            int lastIndexSet = 0;
            for(int i=A.length-2; i>=0; i--)
            {
                int num = A[i];
                if(num == 0)
                {
                    temp[i] = Integer.MAX_VALUE;
                }
                else if(A.length-1-i <= num)
                {
                    temp[i] = 1;
                }
                else
                {
                    int localMinimum = Integer.MAX_VALUE;

                    for(int j = i + 1; j < A.length &&
                            j - i <= A[i]; ++j) {
                        if(temp[j] < localMinimum) {
                            localMinimum = temp[j];
                            if(localMinimum == 1)
                                break;
                        }
                    }
                    temp[i] = localMinimum == Integer.MAX_VALUE ?
                            localMinimum : localMinimum + 1;

                }
            }

            result = temp[0];
        }

        return result;
    }
}
