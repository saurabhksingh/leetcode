package com.dev.saurabh.leetcode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Copyright (c)
 * User: saurabh
 * Date: 8/11/12
 * Time: 2:40 AM
 * This file is created and owned by Saurabh Kr Singh (saurabh.nsit@gmail.com).
 * The code written here is being released under Apache 2.0 License
 */
public class Combinations {

    public static void main(String [] args)
    {
        Combinations combs = new Combinations();
        ArrayList<ArrayList<Integer>> result = combs.combine(4, 2);

        for(ArrayList<Integer> list : result)
        {
            for(int data : list)
            {
                System.out.print(data+" ");
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>>();
        getCombination(n, k, new ArrayList<Integer>(), sol);
        return sol;
    }

    private void getCombination(int n, int k, ArrayList<Integer> partial, ArrayList<ArrayList<Integer>> sol)
    {
        if(partial.size() == k && !sol.contains(partial))
        {
            Collections.sort(partial);
            sol.add(partial);
        }
        else if(partial.size() > k)
        {
            return;
        }
        else
        {
            for(int i = n; i >= 1; --i) {
                ArrayList<Integer> partialSolution = new ArrayList<Integer>();
                partialSolution.addAll(partial);
                partialSolution.add(i);
                getCombination(i - 1, k, partialSolution, sol);
            }
        }
    }
}
