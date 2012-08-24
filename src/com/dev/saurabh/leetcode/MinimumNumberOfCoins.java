package com.dev.saurabh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Copyright (c)
 * User: saurabh
 * Date: 8/24/12
 * Time: 10:33 AM
 * This file is created and owned by Saurabh Kr Singh (saurabh.nsit@gmail.com).
 * The code written here is being released under Apache 2.0 License
 */
public class MinimumNumberOfCoins {

    public static void main(String [] args)
    {
        MinimumNumberOfCoins instance = new MinimumNumberOfCoins();

        int result = instance.minimumCoins(new int[]{10,1,2,7,6,1,5,8}, 8);

        if(result > 0)
        {
            System.out.println("Minimum number of coins : "+ result);
        }
        else
        {
            System.out.println("Target sum can not be achieved !!");
        }
    }

    public int minimumCoins(int[] candidates, int target)
    {

        if(candidates == null || candidates.length < 1)
        {
            return -1;//sum cant be done
        }
        Arrays.sort(candidates);
        int upperIndex = candidates.length-1;

        while(true)
        {
            if(upperIndex<0 || candidates[upperIndex--] > target) break;
        }
        if(upperIndex < 0)
        {
            return -1;//sum cant be done
        }

        candidates = Arrays.copyOfRange(candidates, 0, upperIndex+1);
        int [] result = new int[]{0};
        populateSubSet(candidates,0, candidates.length, target, new ArrayList<Integer>(), result);

        return result[0];
    }

    private void populateSubSet(int[] input, int startIndex, int endIndex, int target, ArrayList<Integer> partial, int[] result) {
        int sum = 0;
        for(int i : partial)
        {
            sum += i;
            if(sum > target)
            {
                return;
            }
        }
        if(sum == target)
        {
            {
                if(result[0] > partial.size() || result[0] == 0)
                {
                    result[0] = partial.size();
                }
            }

            return;
        }
        else if(sum < target)
        {
            for(int i = startIndex; i < endIndex; ++i)
            {
                if(input[i] > target)
                {
                    return;
                }
                ArrayList<Integer> partialSolution = new ArrayList<Integer>();
                partialSolution.addAll(partial);
                partialSolution.add(input[i]);
                populateSubSet(input,i+1,input.length - 1 - i,target, partialSolution, result);
            }
        }
        else
        {
            return;
        }
    }
}
