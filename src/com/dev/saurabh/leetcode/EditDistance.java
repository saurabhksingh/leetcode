package com.dev.saurabh.leetcode;

/**
 * Copyright (c)
 * User: saurabh
 * Date: 8/11/12
 * Time: 12:34 PM
 * This file is created and owned by Saurabh Kr Singh (saurabh.nsit@gmail.com).
 * The code written here is being released under Apache 2.0 License
 */
public class EditDistance {


    public static void main(String [] args)
    {
        EditDistance instance = new EditDistance();
        System.out.println(instance.minDistance("sunday", "saturday"));
    }

    /**
     * Implementation of Levenshtein Distance
     */
    public int minDistance(String word1, String word2)
    {
        // for all i and j, d[i,j] will hold the Levenshtein distance between
        // the first i characters of s and the first j characters of t;
        // note that d has (m+1)x(n+1) values
        //where m is length of word1 and n is length of word2
        int m=word1.length(), n=word2.length();
        int [][] d = new int[m+1][n+1];

        for(int i=1; i<=m; i++)
        {
            d[i][0] = i;
        }
        for(int i=1; i<=n; i++)
        {
            d[0][i] = i;
        }

        for(int j=1; j<=n; j++)
        {
            for(int i=1; i<=m; i++)
            {
                if(word1.charAt(i-1) == word2.charAt(j-1))
                {
                    d[i][j] = d[i-1][j-1];
                }
                else
                {
                    d[i][j] = Math.min(d[i-1][j] + 1, Math.min(d[i][j-1] + 1, d[i-1][j-1] + 1));
                }
            }
        }

        return d[m][n];
    }
}
