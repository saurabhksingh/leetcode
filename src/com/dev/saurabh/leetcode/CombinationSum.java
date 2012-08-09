package com.dev.saurabh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Copyright (c)
 * User: saurabh
 * Date: 8/8/12
 * Time: 8:25 PM
 * This file is created and owned by Saurabh Kr Singh (saurabh.nsit@gmail.com).
 * The code written here is being released under Apache 2.0 License
 */
public class CombinationSum {

    public static void main(String [] args)
    {
       CombinationSum instance = new CombinationSum();
        ArrayList<ArrayList<Integer>> result = instance.combinationSum(new int[]{8,7,2}, 6);
        for(ArrayList<Integer> list : result)
        {
            for(int data : list)
            {
                System.out.print(data+" ");
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Integer>> combinationSum(int [] candidates, int target)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(candidates);
        int upperIndex = candidates.length-1;
        int start =0, end=candidates.length-1;
        while(true)
        {
            int mid = start+ (end-start)/2;
            if(candidates[mid] > target)
            {
                end = mid-1;
            }
            else if(candidates[mid] < target)
            {
                start = mid+1;
            }
            else
            {
                upperIndex = mid;
                break;
            }

            if(start>=end)
            {
               upperIndex = end;
               break;
            }
        }

        int [] candidateCount = new int[upperIndex+1];
        populateSubSet(result, candidateCount, 0, upperIndex, candidates, target);
        return result;
    }

    private void populateSubSet(ArrayList<ArrayList<Integer>> arrayLists, int[] candidateCount, int startIndex, int endIndex, int[] candidates, int target)
    {

        if(startIndex>=(endIndex+1))
        {
            ArrayList<Integer> currentCombination = new ArrayList<Integer>();
            for(int i=0; i<=endIndex; i++)
            {
                if(candidateCount[i]!=0)
                {
                  for(int j=0; j<candidateCount[i]; j++)
                  {
                      currentCombination.add(candidates[i]);
                  }
                }
            }
            if(currentCombination.size() > 0)
            {
                //Collections.sort(currentCombination);
                arrayLists.add(currentCombination);
            }
            return;
        }

        if(startIndex == endIndex)
        {
            if(target%candidates[startIndex]==0)
            {
                candidateCount[startIndex] = target/candidates[startIndex];
                populateSubSet(arrayLists, candidateCount, startIndex+1, endIndex, candidates, 0);
            }
        }
        else
        {
            int iterateUpTo = target/candidates[startIndex];
            for(int i=0; i<=iterateUpTo; i++)
            {
                candidateCount[startIndex] = i;
                populateSubSet(arrayLists, candidateCount, startIndex + 1, endIndex, candidates, target - candidates[startIndex] * i);
            }
        }
    }
}
