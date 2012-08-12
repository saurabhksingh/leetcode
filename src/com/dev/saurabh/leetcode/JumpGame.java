package com.dev.saurabh.leetcode;

/**
 * Copyright (c)
 * User: saurabh
 * Date: 8/12/12
 * Time: 10:34 PM
 * This file is created and owned by Saurabh Kr Singh (saurabh.nsit@gmail.com).
 * The code written here is being released under Apache 2.0 License
 */
public class JumpGame {

    public static void main(String [] args)
    {
      JumpGame instance = new JumpGame();
        System.out.println(instance.canJump(new int[]{2,2,0,2,0,2,0,0,2,0}));
    }

    public boolean canJump(int [] A)
    {
        boolean result = false;
        if(A.length == 1)
        {
            result = true;
        }
        else
        {
            int [] temp = new int [A.length];
            int linkCount = 0;
            if(A[0] == 0)
            {
                return false;
            }
            int lastIndexSet = 0;
            for(int i=0; i<A.length-1; i++)
            {
                int num = A[i];
                if((num == 0 && lastIndexSet==i) || lastIndexSet < i-1)
                {
                    return false;
                }
                if(num > 0)
                {
                    int j=lastIndexSet+1;
                    int loopCount = A[i];

                    if(j > i+loopCount)
                    {
                        continue;
                    }
                    loopCount = loopCount - (lastIndexSet-i);

                    while(j < A.length && loopCount-- > 0)
                    {
                        temp[j++] = 1;
                        if(j == A.length)
                        {
                            boolean isZeroEncountered = false;
                            for(int k=1; k<A.length; k++)
                            {
                               if(temp[k] == 0)
                               {
                                   isZeroEncountered = true;
                                   break;
                               }
                            }
                            return !isZeroEncountered;
                        }

                        lastIndexSet = j-1;
                    }


                }

                if(temp[i] == 1)
                {
                    linkCount++;
                }
            }
            if(temp[A.length-1] == 1)
            {
                linkCount++;
            }

            if(linkCount == A.length-1)
            {
                result = true;
            }

        }

        return result;
    }
}
