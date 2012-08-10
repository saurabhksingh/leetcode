package com.dev.saurabh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Copyright (c)
 * User: saurabh
 * Date: 8/9/12
 * Time: 10:06 AM
 * This file is created and owned by Saurabh Kr Singh (saurabh.nsit@gmail.com).
 * The code written here is being released under Apache 2.0 License
 */
public class CombinationSumII {

    public static void main(String [] args)
    {
        CombinationSumII instance = new CombinationSumII();
        ArrayList<ArrayList<Integer>> result = instance.combinationSum2(new int[]{10,1,2,7,6,1,5,8}, 8);
        for(ArrayList<Integer> list : result)
        {
            for(int data : list)
            {
                System.out.print(data+" ");
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        int upperIndex = candidates.length-1;

        while(true)
        {
            if(upperIndex<0 || candidates[upperIndex--] > target) break;
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        candidates = Arrays.copyOfRange(candidates, 0, upperIndex+1);
        populateSubSet(candidates, target, new ArrayList<Integer>(), result, upperIndex);
        return result;
    }

    private void populateSubSet(int[] input, int target, ArrayList<Integer> partial, ArrayList<ArrayList<Integer>> result, int upperIndex) {
        int sum = 0;
        for(int i : partial)
        {
            sum += i;
            if(sum > target)
                return;
        }
        if(sum == target) {
            if(!result.contains(partial))
                result.add(partial);
            return;
        } else if(sum > target) {
            return;
        } else {
            for(int i = 0; i < input.length; ++i) {
                int[] remaining = new int[input.length - 1 - i];
                System.arraycopy(input, i + 1, remaining, 0, remaining.length);
                ArrayList<Integer> partialSolution = new ArrayList<Integer>();
                if(input[i] > target)
                    return;
                partialSolution.addAll(partial);
                partialSolution.add(input[i]);
                populateSubSet(remaining, target, partialSolution, result, upperIndex);
            }
        }
    }
}